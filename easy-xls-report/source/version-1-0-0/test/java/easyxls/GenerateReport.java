package easyxls;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cignexdatamatics.easyxls.util.WorkBook;
import com.cignexdatamatics.easyxls.util.XLSReport;

public class GenerateReport implements XLSReport
{

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
