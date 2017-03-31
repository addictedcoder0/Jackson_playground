//$Id$
package com.jackson.treemodel;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.sym.Name;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
/**
 * JsonArray:
 [
 {
  "id"   : 1,
  "name" : {
    "first" : "Yong",
    "last" : "Mook Kim"
  },
  "contact" : [
    { "type" : "phone/home", "ref" : "111-111-1234"},
    { "type" : "phone/work", "ref" : "222-222-2222"}
  ]
},
{
  "id"   : 2,
  "name" : {
    "first" : "Yong",
    "last" : "Zi Lap"
  },
  "contact" : [
    { "type" : "phone/home", "ref" : "333-333-1234"},
    { "type" : "phone/work", "ref" : "444-444-4444"}
  ]
}
]
*
*
*
**/
public class ObjectToJson {
	private static final String DATA_REPO_TREE_MODEL = "/home/local/ZOHOCORP/abhishek-2863/jackson_json/Jackson_playground/treemodel";
	
	public static void main(String[] args) {
		// path : user_infoTree.json
	
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootArray;
		try {
			rootArray = mapper.readTree(new File(DATA_REPO_TREE_MODEL+"/user_infoTree.json"));
			for(JsonNode root : rootArray){
				processSingleUnit(root);
				
				// modify the JSON Tree Node 
				modifySingleUnit(root);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void processSingleUnit(JsonNode root){
		long id ;
		id = root.path("id").asLong();
		JsonNode nameNode = root.path("name");
		
		String fName =  nameNode.path("first").asText();
		String sName = nameNode.path("middle").asText();
		String lName = nameNode.path("last").asText();
		
		System.out.println("\n\n:::: Details :::: ");
		JsonNode contactNodeArray = root.path("contact");
		System.out.println(":: id   :: "+id);
		System.out.println(":: Name :: "+fName+" "+sName+" "+lName);
		
		// check if it is a array
		if(contactNodeArray.isArray()){
			for(JsonNode contactNode : contactNodeArray){
				String type  = contactNode.path("type").asText();
				String ref = contactNode.path("ref").asText();
				System.out.println(":: type :: "+type +":: ref :: "+ref);
			}
			
		}
	} 
	
	public static void modifySingleUnit(JsonNode root){
		ObjectMapper mapper = new ObjectMapper();
		// update id to 123
		((ObjectNode) root).put("id",123L);
		
		//if middleName == "" then ; middleName = "damn";
		JsonNode nameNode =  root.path("name");
		if("".equals(nameNode.path("middle").asText())){
			((ObjectNode) nameNode).put("middle","damn");
		}
		
		//create a new field in nameNode
		((ObjectNode) nameNode).put("nickName","demi-God");
		
		
		//create anew Node and attach it to existing root Node
		ObjectNode positionNode = mapper.createObjectNode();
		positionNode.put("positionName","Developer");
		positionNode.put("Experience", 10);
		((ObjectNode) root).set("position",positionNode);
		
		ArrayNode gamesNode =  mapper.createArrayNode();
		
		ObjectNode game1 = mapper.createObjectNode();
		game1.put("game", "Taken3");
		game1.put("price", 550);
		
		ObjectNode game2 = mapper.createObjectNode();
		game2.put("game", "Hell-unleashed");
		game2.put("price", 500);
		
		gamesNode.add(game1);
		gamesNode.add(game2);
		
		((ObjectNode) root).set("games",gamesNode);
		
		((ObjectNode) root).put("email","abc@gmail.com");
		try {
			String updatedUnit = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
			System.out.println(updatedUnit);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
