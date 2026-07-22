package com.rays.DTO;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "st_stock")
public class StockDTO {

	@Id
	@GeneratedValue(generator = "PK")
	@GenericGenerator(name = "PK", strategy = "native")
	@Column(name = "ID", nullable = false, unique = true)
	private int id;

	@Column(name = "STOCK_NAME", length = 20)
	private String stockName;

	@Column(name = "CODE", length = 20)
	private String code;

	@Column(name = "QUANTITY", length = 5)
	private int quantity;

	@Column(name = "BUY_DATE", length = 10)
	private Date buyDate;

	@Column(name = "STATUS", length = 15)
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
