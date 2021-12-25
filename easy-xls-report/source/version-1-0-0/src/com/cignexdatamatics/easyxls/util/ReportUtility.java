/**
 * Copyright (c) 2000-2012 CIGNEX Datamatics, Inc. All rights reserved.
 * This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 */
package com.cignexdatamatics.easyxls.util;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;

import com.cignexdatamatics.easyxls.anotation.WorkBookProperty;
import com.cignexdatamatics.easyxls.anotation.XLSProperty;
import com.cignexdatamatics.easyxls.exception.XLSReportRuntimeException;

/**
 * 
 * Utility for creating xls report
 * 
 * @author nishit.charania
 * 
 */
public final class ReportUtility
{

	private static final Log LOGGER = LogFactory.getLog(ReportUtility.class);
	private static final String CHECK_SEQUENCE = "Please check column sequence";

	private ReportUtility()
	{

	}

	/**
	 * Method to create report and write in output stream
	 * 
	 * @param out
	 * @param xlsReport
	 * @throws IOException
	 */
	public static void getHSSFWorkbook(final OutputStream out,
			XLSReport xlsReport) throws IOException
	{
		final HSSFWorkbook workbook = ReportUtility.getHSSFWorkbook(xlsReport
				.getReportData());
		workbook.write(out);
	}

	/**
	 * Method to create report and write in output stream
	 * 
	 * @param out
	 * @param workBookObjects
	 * @throws IOException
	 */
	public static void getHSSFWorkbook(final OutputStream out,
			final List<? extends WorkBook> workBookObjects) throws IOException
	{
		final HSSFWorkbook workbook = ReportUtility
				.getHSSFWorkbook(workBookObjects);
		workbook.write(out);
	}

	/**
	 * Method to create HSSF Work book using WorkBooks object
	 * 
	 * @param workBookObjects
	 * @return
	 */
	public static HSSFWorkbook getHSSFWorkbook(
			final List<? extends WorkBook> workBookObjects)
	{
		HSSFWorkbook hssfWorkbook = null;
		if ((null != workBookObjects) && !workBookObjects.isEmpty())
		{
			final WorkBookProperty wbp = workBookObjects.get(0).getClass()
					.getAnnotation(WorkBookProperty.class);
			// get workbook
			hssfWorkbook = new HSSFWorkbook();

			final HSSFSheet sheet = hssfWorkbook
					.createSheet(wbp.WorkBookName());

			final Map<Integer, XLSProperty> xmlsPropertyMap = new LinkedHashMap<Integer, XLSProperty>();
			final Map<Integer, Field> filedPositions = new LinkedHashMap<Integer, Field>();
			ReportUtility.preparePropertyAndPositionMap(workBookObjects,
					xmlsPropertyMap, filedPositions);

			// generate header tile
			final HSSFRow titleRow = sheet.createRow(0);
			ReportUtility.createXLSHeader(hssfWorkbook, xmlsPropertyMap,
					titleRow);

			// filling XLS data
			// first we are filling first column
			for (final Entry<Integer, Field> filedPosition : filedPositions
					.entrySet())
			{
				// get class time to find data is for Type of
				// String,Date,Integer
				final Class<?> classType = filedPosition.getValue().getType();
				int rowCount = 1;
				for (final WorkBook workBooks : workBookObjects)
				{
					HSSFRow dataRow = sheet.getRow(rowCount);
					if (null == dataRow)
					{
						dataRow = sheet.createRow(rowCount);
					}
					// we found row so inc rowCount
					rowCount++;
					// create cell in to the row
					final HSSFCell cell = dataRow.createCell(filedPosition
							.getKey());
					final Object value = ReportUtility.getValueFromObject(
							filedPosition, workBooks);
					ReportUtility.setCellValue(hssfWorkbook,
							xmlsPropertyMap.get(filedPosition.getKey()),
							classType, cell, value);
				}
			}

		} else
		{
			hssfWorkbook = null;
		}

		return hssfWorkbook;

	}

	/**
	 * Method to set cell value using its type
	 * 
	 * @param hssfWorkbook
	 * @param xlsProperty
	 * @param classType
	 * @param cell
	 * @param value
	 */
	private static void setCellValue(final HSSFWorkbook hssfWorkbook,
			final XLSProperty xlsProperty, final Class<?> classType,
			final HSSFCell cell, final Object value)
	{
		if (classType.equals(String.class))
		{
			cell.setCellValue((String) value);
		} else if (classType.equals(Double.class)
				|| classType.equals(double.class))
		{
			cell.setCellValue((Double) value);

		} else if (classType.equals(Date.class))
		{
			final CellStyle dateCellStyle = hssfWorkbook.createCellStyle();
			final CreationHelper createHelper = hssfWorkbook
					.getCreationHelper();
			dateCellStyle.setDataFormat(createHelper.createDataFormat()
					.getFormat(xlsProperty.columnDataDateFormat()));
			cell.setCellStyle(dateCellStyle);
			cell.setCellValue((Date) value);

		} else if (classType.equals(Boolean.class)
				|| classType.equals(boolean.class))
		{
			cell.setCellValue((Boolean) value);
		} else
		{
			cell.setCellValue(String.valueOf(value));
		}
	}

	/**
	 * Method to get value from workBook object using reflection API
	 * 
	 * @param filedPosition
	 * @param workBook
	 * @return
	 */
	private static Object getValueFromObject(
			final Entry<Integer, Field> filedPosition, final WorkBook workBook)
	{
		Object value = null;
		try
		{
			value = PropertyUtils.getProperty(workBook, filedPosition
					.getValue().getName());
		} catch (final IllegalAccessException e)
		{
			ReportUtility.LOGGER.error(ExceptionUtils.getFullStackTrace(e));
			throw new XLSReportRuntimeException(e);
		} catch (final InvocationTargetException e)
		{
			ReportUtility.LOGGER.error(ExceptionUtils.getFullStackTrace(e));
			throw new XLSReportRuntimeException(e);
		} catch (final NoSuchMethodException e)
		{
			ReportUtility.LOGGER.error(ExceptionUtils.getFullStackTrace(e));
			throw new XLSReportRuntimeException(e);
		}
		return value;
	}

	/**
	 * Method to create Header in XLS
	 * 
	 * @param workbook
	 * @param xmlsPropertyMap
	 * @param titleRow
	 */
	private static void createXLSHeader(final HSSFWorkbook workbook,
			final Map<Integer, XLSProperty> xmlsPropertyMap,
			final HSSFRow titleRow)
	{
		for (final Entry<Integer, XLSProperty> xlsColumnProperty : xmlsPropertyMap
				.entrySet())
		{
			// get style for header row
			final HSSFCellStyle cellStyle = workbook.createCellStyle();
			final HSSFFont font = workbook.createFont();
			font.setBoldweight(xlsColumnProperty.getValue().columnTitleBoldWeight());			
			cellStyle.setFont(font);

			final HSSFCell titleCell = titleRow.createCell(xlsColumnProperty
					.getKey());
			titleCell.setCellValue(xlsColumnProperty.getValue().columnTitle());
			titleCell.setCellStyle(cellStyle);
		}
	}

	/**
	 * Method to prepare property and position map
	 * 
	 * @param workBookObjects
	 * @param xmlsPropertyMap
	 * @param filedPositions
	 */
	private static void preparePropertyAndPositionMap(
			final List<? extends WorkBook> workBookObjects,
			final Map<Integer, XLSProperty> xmlsPropertyMap,
			final Map<Integer, Field> filedPositions)
	{
		for (final Field field : workBookObjects.get(0).getClass()
				.getDeclaredFields())
		{
			final XLSProperty xlsProperty = field
					.getAnnotation(XLSProperty.class);
			if (null != xlsProperty)
			{
				if (xmlsPropertyMap.containsKey(xlsProperty.columnSeq()))
				{
					throw new XLSReportRuntimeException(CHECK_SEQUENCE);
				}
				xmlsPropertyMap.put(xlsProperty.columnSeq(), xlsProperty);
				filedPositions.put(xlsProperty.columnSeq(), field);
			}
		}
	}
}
