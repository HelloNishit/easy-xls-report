/**
 * Copyright (c) 2000-2012 CIGNEX Datamatics, Inc. All rights reserved.
 * This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 */
package easyxls;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import com.cignexdatamatics.easyxls.util.ReportUtility;

public class ReportTest
{

	@Test
	public void testReport()
	{
		GenerateReport generateReport = new GenerateReport();
		File file = new File("test_report.xls");
		FileOutputStream fos = null;
		try
		{
			fos = new FileOutputStream(file);
			ReportUtility.getHSSFWorkbook(fos, generateReport);			
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(null != fos)
			{
				try
				{
					fos.close();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	@Test
	public void testCustomHeaderReport()
	{
		GenerateReport generateReport = new GenerateReport();
		File file = new File("test_report1.xls");
		FileOutputStream fos = null;
		try
		{
			fos = new FileOutputStream(file);			
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
			final HSSFSheet sheet = hssfWorkbook.createSheet("workbookName");
			List data = generateReport.getReportData() ;
			ReportUtility.prepareWorkBookSheet(data,hssfWorkbook,sheet) ;
			data.remove(3) ;
			ReportUtility.prepareWorkBookSheet(data,hssfWorkbook,sheet) ;
			data.remove(1) ;
			ReportUtility.prepareWorkBookSheet(generateReport.getReportData2(),hssfWorkbook,sheet) ;
			ReportUtility.prepareWorkBookSheet(data,hssfWorkbook,sheet) ;
			hssfWorkbook.write(fos) ;
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(null != fos)
			{
				try
				{
					fos.close();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
