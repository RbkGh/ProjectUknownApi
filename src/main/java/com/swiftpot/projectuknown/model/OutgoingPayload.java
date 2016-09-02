package com.swiftpot.projectuknown.model;

import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 */

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at rbk.unlimited@gmail.com> on
 *         02-Sep-16
 */
@XmlRootElement
@Component
public class OutgoingPayload {

	private String status;
	private String message;
	private Object responseObject;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getResponseObject() {
		return responseObject;
	}
	public void setResponseObject(Object responseObject) {
		this.responseObject = responseObject;
	}
	
}
