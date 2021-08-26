package com.tibco.bw.sharedresource.tas.model.helper;

public class TasResponse {

	private boolean hasError = true;
	private String message;
	private int statusCode;

	public boolean isHasError() {
		return hasError;
	}
	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}
	public String getMessage() {
		return message;
	}
//	public void setMessage(String message) {
//		this.message = message;
//	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public void setErrorMessage(String errorMessage){
		hasError = true;
		message = errorMessage;
	}

	public void setSuccessfulResponse(String message){
		hasError = false;
		this.message = message;
	}

}
