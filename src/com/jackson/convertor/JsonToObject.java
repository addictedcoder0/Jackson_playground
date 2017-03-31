//$Id$
package com.jackson.convertor;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
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
					
			//JsonObject-String to Object conversion
			// this approach uses , getter-setter based initialisation
			String jsonInString =  "{\"name\":\"mkyong\",\"salary\":7500,\"skills\":[\"java\",\"python\"]}";
			Staff staff_from_String = mapper.readValue(jsonInString,Staff.class);
			System.out.println(staff_from_String);
			
			//jsonArray-String to List<Object>
			String jsonString_for_staffs = "[{\"name\":\"mkyong1\",\"salary\":7500,\"skills\":[\"java\",\"python\"]},{\"name\":\"mkyong2\",\"salary\":7500,\"skills\":[\"java7\",\"python3\"]},{\"name\":\"mkyong3\",\"salary\":7500,\"skills\":[\"java8\",\"Rust\"]}]";
			List<Staff> listOfStaffs =  mapper.readValue(jsonString_for_staffs, new TypeReference<List<Staff>>(){});
			System.out.println(listOfStaffs.toString());
			
			//jsonObject-String to Map<String, Object>
			Map<String,Object> map = mapper.readValue(jsonInString, new TypeReference<Map<String,Object>>() {
			});
			System.out.println(map.toString());
			
			//jsonArray-String to List<Map<String,Object>>
			List<Map<String,Object>> list_of_map = mapper.readValue(jsonString_for_staffs	, new TypeReference<List<Map<String,Object>>>() {
			});
			System.out.println(list_of_map.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
