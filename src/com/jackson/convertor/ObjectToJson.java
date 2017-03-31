//$Id$

/**
 *   Used libs :  jackson-annotations-2.8.6.jar  ,  jackson-core-2.8.6.jar  , jackson-databind-2.8.7.jar
 */

package com.jackson.convertor;


import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jackson.person.Staff;

public class ObjectToJson {
	static final String DATA_REPOSITORY = "/home/local/ZOHOCORP/abhishek-2863/jackson_json/Jackson_playground/staff_info";
	
	public static void main(String[] args) {
		ObjectToJson objtoJson =  new ObjectToJson();
		objtoJson.run();
	}
	
	private void run(){
		ObjectMapper mapper = new ObjectMapper();
		Staff dummyStaff = createDummyStaff();
		
		try {
			
			// converting obj to JSON String and save into a file Directory
			mapper.writeValue(new File(DATA_REPOSITORY+"/staff.json"), dummyStaff);
			
			
			//convert Object to JSON String
			String jsonInString = mapper.writeValueAsString(dummyStaff);
			System.out.println(jsonInString);
			
			//convert Object to JSON String and then PrettyPrint it 
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dummyStaff);
			System.out.println("\n\n:::: pretty print ::::\n\n"+jsonInString);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	private Staff createDummyStaff(){
		return new Staff("Rudra", 25, "CTO", new BigDecimal(10004040505.95), Arrays.asList("java","rust","full-stack"));
	}
}
