package com.fuber.cab.domain.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Length(max=30,min=5)
	private String name;
	@Length(max=30)
	private String email;
	@Length(max=10)
	private String mobileNo;
	private BigDecimal defaultLat;
	private BigDecimal defaultLong;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public BigDecimal getDefaultLat() {
		return defaultLat;
	}
	public void setDefaultLat(BigDecimal defaultLat) {
		this.defaultLat = defaultLat;
	}
	public BigDecimal getDefaultLong() {
		return defaultLong;
	}
	public void setDefaultLong(BigDecimal defaultLong) {
		this.defaultLong = defaultLong;
	}
	

}
