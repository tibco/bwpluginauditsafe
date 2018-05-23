/*
 *
 * Copyright2011 - 2013 TIBCO Software Inc.
 * All rights reserved.
 *
 * This software is confidential and proprietary information of TIBCO Software Inc.
 * Overridable true
 */
package com.tibco.bw.sharedresource.tcta.runtime;

public class tctaConnectionResource {
	private Integer spinner; 
	private String comboViewer; 
	private String textBox; 

	public void setSpinner (Integer spinner) {
		this.spinner = spinner;
	}
	public void setComboViewer (String comboViewer) {
		this.comboViewer = comboViewer;
	}
	public void setTextBox (String textBox) {
		this.textBox = textBox;
	}
	public Integer getSpinner() {
		return spinner;
	}
	public String getComboViewer() {
		return comboViewer;
	}
	public String getTextBox() {
		return textBox;
	}
}
