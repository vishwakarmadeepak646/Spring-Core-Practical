package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name="st_attendance")
public class AttendanceDTO extends BaseDTO{

	@Column(name="STDID", length=50)
	Long stdId;
	
	@Column(name="DATE", length=50)
	Date date;
	
	@Column(name="STATUS", length=50)
	String status;
	
	@Column(name="REMARKS", length=250)
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
	
	
	
}
