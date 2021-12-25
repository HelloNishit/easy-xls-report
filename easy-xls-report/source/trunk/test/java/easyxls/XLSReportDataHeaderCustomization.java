/**
 * Copyright (c) 2000-2012 CIGNEX Datamatics, Inc. All rights reserved.
 * This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 */
package easyxls;

import java.util.Date;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Font;

import com.cignexdatamatics.easyxls.anotation.WorkBookProperty;
import com.cignexdatamatics.easyxls.anotation.XLSProperty;
import com.cignexdatamatics.easyxls.util.ReportUtility;
import com.cignexdatamatics.easyxls.util.WorkBook;

@WorkBookProperty(WorkBookName = "Test Work Book",customMethodClass=XLSReportDataHeaderCustomization.class,customTitleMethod="myHeaderMethod")
public class XLSReportDataHeaderCustomization implements WorkBook {
	@XLSProperty(columnSeq = 0, columnTitle = "Id", columnTitleBoldWeight = Font.BOLDWEIGHT_BOLD)
	private Integer studentId;
	@XLSProperty(columnSeq = 1, columnTitle = "Name", columnTitleBoldWeight = Font.BOLDWEIGHT_BOLD)
	private String studentName;
	@XLSProperty(columnSeq = 2, columnTitle = "Exam Date", columnTitleBoldWeight = Font.BOLDWEIGHT_BOLD, columnDataDateFormat = "MM/dd/yyyy")
	private Date dateOfExam;	

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Date getDateOfExam() {
		return dateOfExam;
	}

	public void setDateOfExam(Date dateOfExam) {
		this.dateOfExam = dateOfExam;
	}
	
	public static void myHeaderMethod(HSSFWorkbook hssfWorkbook,HSSFSheet sheet,Map<Integer, XLSProperty> xmlsPropertyMap)
	{
		HSSFRow titleRow = sheet.createRow(sheet.getLastRowNum());
		final HSSFCell titleCell = titleRow.createCell(2);
		titleCell.setCellValue("my test");
		// generate header tile		
		titleRow = sheet.createRow(sheet.getLastRowNum()+1);
		ReportUtility.createXLSHeader(hssfWorkbook, xmlsPropertyMap,
				titleRow);	
	}

}
