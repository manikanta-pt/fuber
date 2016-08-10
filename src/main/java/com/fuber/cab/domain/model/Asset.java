package com.fuber.cab.domain.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
@Entity 
@Table(name="Asset")
public class Asset {  
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Length(max=30,min=5)
	private String number;//numberplate
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	private Integer capacity;
	@Length(max=30,min=5)
	private String Color;
	private BigDecimal defaultLat;
	private BigDecimal defaultLong;
	
	private BigDecimal currentLat;
	private BigDecimal currentLong;
	private String status;
	public BigDecimal getCurrentLat() {
		return currentLat;
	}
	public void setCurrentLat(BigDecimal currentLat) {
		this.currentLat = currentLat;
	}
	public BigDecimal getCurrentLong() {
		return currentLong;
	}
	public void setCurrentLong(BigDecimal currentLong) {
		this.currentLong = currentLong;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
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
