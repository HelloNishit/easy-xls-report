/**
 * Copyright (c) 2000-2012 CIGNEX Datamatics, Inc. All rights reserved.
 * This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 */
package easyxls;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cignexdatamatics.easyxls.util.WorkBook;
import com.cignexdatamatics.easyxls.util.XLSReport;

public class GenerateReport implements XLSReport
{
	public List<? extends WorkBook> getReportData2()
	{
		List<XLSReportDataHeaderCustomization> xlsReportDataClassList = new ArrayList<XLSReportDataHeaderCustomization>();
		XLSReportDataHeaderCustomization xlsReportDataClass1 = new XLSReportDataHeaderCustomization();
		xlsReportDataClassList.add(xlsReportDataClass1);
		xlsReportDataClass1.setDateOfExam(new Date());
		xlsReportDataClass1.setStudentId(1);
		xlsReportDataClass1.setStudentName("A");
		

		xlsReportDataClass1 = new XLSReportDataHeaderCustomization();
		xlsReportDataClassList.add(xlsReportDataClass1);
		xlsReportDataClass1.setDateOfExam(new Date());
		xlsReportDataClass1.setStudentId(2);
		xlsReportDataClass1.setStudentName("B");
		

		xlsReportDataClass1 = new XLSReportDataHeaderCustomization();
		xlsReportDataClassList.add(xlsReportDataClass1);
		xlsReportDataClass1.setDateOfExam(new Date());
		xlsReportDataClass1.setStudentId(3);
		xlsReportDataClass1.setStudentName("C");
		

		xlsReportDataClass1 = new XLSReportDataHeaderCustomization();
		xlsReportDataClassList.add(xlsReportDataClass1);
		xlsReportDataClass1.setDateOfExam(new Date());
		xlsReportDataClass1.setStudentId(4);
		xlsReportDataClass1.setStudentName("D");
		

		return xlsReportDataClassList;
	}

	@Override
	public List<? extends WorkBook> getReportData()
	{
		List<XLSReportDataClass> xlsReportDataClassList = new ArrayList<XLSReportDataClass>();
		XLSReportDataClass xlsReportDataClass = new XLSReportDataClass();
		xlsReportDataClassList.add(xlsReportDataClass);
		xlsReportDataClass.setDateOfExam(new Date());
		xlsReportDataClass.setStudentId(1);
		xlsReportDataClass.setStudentName("A");
		xlsReportDataClass.setSubjectMark1(55.55f);
		xlsReportDataClass.setTotalMark(55.55);

		xlsReportDataClass = new XLSReportDataClass();
		xlsReportDataClassList.add(xlsReportDataClass);
		xlsReportDataClass.setDateOfExam(new Date());
		xlsReportDataClass.setStudentId(2);
		xlsReportDataClass.setStudentName("B");
		xlsReportDataClass.setSubjectMark1(50.12f);
		xlsReportDataClass.setTotalMark(50.12);

		xlsReportDataClass = new XLSReportDataClass();
		xlsReportDataClassList.add(xlsReportDataClass);
		xlsReportDataClass.setDateOfExam(new Date());
		xlsReportDataClass.setStudentId(3);
		xlsReportDataClass.setStudentName("C");
		xlsReportDataClass.setSubjectMark1(5.09f);
		xlsReportDataClass.setTotalMark(50.3344);

		xlsReportDataClass = new XLSReportDataClass();
		xlsReportDataClassList.add(xlsReportDataClass);
		xlsReportDataClass.setDateOfExam(new Date());
		xlsReportDataClass.setStudentId(4);
		xlsReportDataClass.setStudentName("D");
		xlsReportDataClass.setSubjectMark1(0.00f);
		xlsReportDataClass.setTotalMark(0.00);

		return xlsReportDataClassList;
	}

}
