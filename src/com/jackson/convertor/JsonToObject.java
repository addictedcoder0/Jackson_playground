//$Id$
package com.jackson.convertor;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jackson.person.Staff;

public class JsonToObject {

	public static void main(String[] args) {
		JsonToObject jsonToObj =  new JsonToObject();
		jsonToObj.run();
	}
	
	private void run(){
		ObjectMapper mapper = new ObjectMapper();
		try {
			
			//Reading JSON string from the file and then converting back to Object
			// we require a default-constructor in the Staff class , for this conversion
			Staff dummyStaff = mapper.readValue(new File(ObjectToJson.DATA_REPOSITORY+"/staff.json"),Staff.class);
			System.out.println(dummyStaff);
			
			
			//Json-String to Object conversion
			// this approach uses , getter-setter based initialisation
			String jsonInString =  "{\"name\":\"mkyong\",\"salary\":7500,\"skills\":[\"java\",\"python\"]}";
			Staff staff_from_String = mapper.readValue(jsonInString,Staff.class);
			System.out.println(staff_from_String);
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
