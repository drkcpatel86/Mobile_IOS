package com.mobile.runner;

import com.hybrid.mgmt.Constants;
import com.relevantcodes.extentreports.ExtentTest;

public class AppKeywords extends GenericKeywords {

	public AppKeywords(ExtentTest test){
		super(test);
	}
	public String addexpense(){
		System.out.println("Adding expense");
		return Constants.PASS;
	}
}
