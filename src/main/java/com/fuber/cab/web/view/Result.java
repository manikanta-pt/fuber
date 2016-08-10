package com.fuber.cab.web.view;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Result {
	
	private String status="";
	private String message="";
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private String error="";
	private String erorMessage="";
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getErorMessage() {
		return erorMessage;
	}
	public void setErorMessage(String erorMessage) {
		this.erorMessage = erorMessage;
	}

}
