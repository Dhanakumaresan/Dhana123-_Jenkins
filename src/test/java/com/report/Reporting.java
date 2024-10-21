package com.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {
public static void generateJVMReport(String jsonFile) {
		
		//1. Mention the report location
		File reportDirectory=new File(System.getProperty("user.dir") + "\\target");
		
		//2.Set the Configuration for report
		Configuration configuration=new Configuration(reportDirectory,"Jenkins");
		
		//3. add Classifications for report
		configuration.addClassifications("platformName","Windows");
		configuration.addClassifications("platformVersion","10");
		configuration.addClassifications("environment","QA");
		configuration.addClassifications("sprint","30");
		configuration.addClassifications("author","Dhana");
		
		//4. add jsonFile to List
		List<String> jsonFiles=new ArrayList<>();
		jsonFiles.add(jsonFile);
		
		//5. Create object for reportBuilder class
		ReportBuilder builder=new ReportBuilder(jsonFiles,configuration);
		builder.generateReports();

	}

}
