package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.AttendanceDTO;

public class AttendanceForm extends BaseForm {

	@NotNull(message = "stdId is required")
	Long stdId;

	@NotNull(message = "Date is required")
	Date date;

	@NotEmpty(message = "Status is required")
	String status;

	@NotEmpty(message = "remarks is required")
	String remarks;

	public Long getStdId() {
		return stdId;
	}

	public void setStdId(Long stdId) {
		this.stdId = stdId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public BaseDTO getDto() {
		AttendanceDTO dto = (AttendanceDTO) initDTO(new AttendanceDTO());
		dto.setStdId(stdId);
		dto.setStatus(status);
		dto.setDate(date);
		dto.setRemarks(remarks);

		return dto;
	}

}
