/**
 * Copyright (c) 2000-2012 CIGNEX Datamatics, Inc. All rights reserved.
 * This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 */
package easyxls;

import java.util.Date;

import org.apache.poi.ss.usermodel.Font;

import com.cignexdatamatics.easyxls.anotation.WorkBookProperty;
import com.cignexdatamatics.easyxls.anotation.XLSProperty;
import com.cignexdatamatics.easyxls.util.WorkBook;

@WorkBookProperty(WorkBookName = "Test Work Book")
public class XLSReportDataClass implements WorkBook {
	@XLSProperty(columnSeq = 0, columnTitle = "Id", columnTitleBoldWeight = Font.BOLDWEIGHT_BOLD)
	private Integer studentId;
	@XLSProperty(columnSeq = 1, columnTitle = "Name", columnTitleBoldWeight = Font.BOLDWEIGHT_BOLD)
	private String studentName;
	@XLSProperty(columnSeq = 2, columnTitle = "Exam Date", columnTitleBoldWeight = Font.BOLDWEIGHT_BOLD, columnDataDateFormat = "MM/dd/yyyy")
	private Date dateOfExam;
	@XLSProperty(columnSeq = 3, columnTitle = "Math", columnTitleBoldWeight = Font.BOLDWEIGHT_BOLD)
	private Float subjectMark1;
	@XLSProperty(columnSeq = 4, columnTitle = "Total", columnTitleBoldWeight = Font.BOLDWEIGHT_BOLD)
	private Double totalMark;

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

	public Float getSubjectMark1() {
		return subjectMark1;
	}

	public void setSubjectMark1(Float subjectMark1) {
		this.subjectMark1 = subjectMark1;
	}

	public Double getTotalMark() {
		return totalMark;
	}

	public void setTotalMark(Double totalMark) {
		this.totalMark = totalMark;
	}

}
