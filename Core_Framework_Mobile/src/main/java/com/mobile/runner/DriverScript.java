package com.mobile.runner;

import java.lang.reflect.Method;
import java.util.Hashtable;

import com.hybrid.mgmt.Constants;
import com.hybrid.mgmt.Xls_Reader;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DriverScript {
	ExtentTest test;
	AppKeywords keywords;
	public DriverScript(ExtentTest test){
		this.test=test;
		keywords = new AppKeywords(test);
	}

	//public static void main(String[] args) {
	public void executeKeywords(String testUnderExecution,Hashtable<String,String> testData) {
		
		//String testUnderExecution="TC1";
		String keywords_sheet="Keywords";
		
		Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"//data//Data.xlsx");
		int rows = xls.getRowCount(keywords_sheet);
		System.out.println("Total rows - "+ rows);
		
		
		for(int rNum=2;rNum<=rows;rNum++){
			String tcid= xls.getCellData(keywords_sheet, Constants.TCID_COL, rNum);
			if(tcid.equals(testUnderExecution)){
				String keyword= xls.getCellData(keywords_sheet, Constants.KEYWORD_COL, rNum);
				String object= xls.getCellData(keywords_sheet,Constants.OBJECT_COL, rNum);
				String dataKey= xls.getCellData(keywords_sheet, Constants.DATA_COL, rNum);
				test.log(LogStatus.INFO,tcid +" --- "+ keyword + " --- "+ object+" ----- "+testData.get(dataKey));
			//	System.out.println(tcid +" --- "+ keyword + " --- "+ object+" ----- "+data);
				String result="";
				
			
				
				if(keyword.equals("openapp"))
					result=keywords.openapp();
				else if(keyword.equals("click"))
					result=keywords.click(object);
				else if(keyword.equals("type"))
					result=keywords.type(object,testData.get(dataKey));
				else if(keyword.equals("verifyText"))
					result=keywords.verifyText(object,testData.get(dataKey));
				else if(keyword.equals("closeapp"))
					result=keywords.closeapp();
				else if(keyword.equals("addexpense"))
					result=keywords.addexpense();
				
				test.log(LogStatus.INFO,"Result of executing keyword -> "+result);
				if(!result.equals(Constants.PASS)){
					keywords.reportFailure(result);
				}
				
			}
		}
	}
	
	public AppKeywords getKeywords(){
		return keywords;
	}

}
