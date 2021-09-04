package com.mycompany.demo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.mycompany.demo.model.House;

@Service
/**
 * 
 * @author Krish
 *
 */
public class DemoService implements DemoServiceInterface {
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Override
	/**
	 * this method formats the input string to the given specification
	 */
	public String formatInput(String input) throws IOException {
		String responseJson = "";
		Map<String,House> houseMap = new HashMap<String,House>();
		
		// input from client
		JsonNode houseData = null;
		try {
			houseData = objectMapper.readTree(input);
		} catch (Exception ex) {
			throw new IOException("aa");
		}
				
		if (houseData.size() > 0) { // 
			
			// loop through each item 
			for (int i=0; i<houseData.size(); i++) {
				
				// get the first item
				JsonNode houseNode = houseData.get(i+""); // process first id=10
				
				if (houseNode.isArray()) {
					ArrayNode homeArray = (ArrayNode)houseNode;
					for (JsonNode homeNode : homeArray) {
						// populate each house data
						House house = new House();
						if(homeNode.has("id")) {														
							house.setId(homeNode.get("id").asText());								
							houseMap.put(homeNode.get("id").asText(), house);							
						}
						
						if(homeNode.has("title")) {														
							house.setTitle(homeNode.get("title").asText());							
						}
						if(homeNode.has("level")) {														
							house.setLevel(homeNode.get("level").asText());														
						}
						// process children 
						List<House> cldHouseList = new ArrayList<House>();
						house.setChildren(cldHouseList);
						
						if(homeNode.has("parent_id")) {														
							house.setParent_id(homeNode.get("parent_id").asText());
							
							if (houseMap.get(homeNode.get("parent_id").asText()) != null) {
								House parentHouse = houseMap.get(homeNode.get("parent_id").asText());
								
								if (parentHouse.getChildren() != null) {
									parentHouse.getChildren().add(house);
								} else {
									List<House> childrenList = new ArrayList<House>();
									childrenList.add(house);
									parentHouse.setChildren(childrenList);
								}
							}
						}
						
						if (homeNode.has("children")) {
							
							// check here ???
							JsonNode cldNode = homeNode.get("children");
								
								if (cldNode.isArray()) {
									
									ArrayNode cldHomeArray = (ArrayNode)cldNode;
									
									for(JsonNode cldHouseNode : cldHomeArray) {
										
										House cldHouse = new House();
										cldHouseList.add(cldHouse);
										
										if(cldHouseNode.has("id")) {														
											cldHouse.setId(cldHouseNode.get("id").asText());								
										}
										
										if(cldHouseNode.has("title")) {														
											cldHouse.setTitle(cldHouseNode.get("title").asText());							
										}
										if(cldHouseNode.has("level")) {														
											cldHouse.setLevel(cldHouseNode.get("level").asText());														
										}
										if(cldHouseNode.has("parent_id")) {														
											cldHouse.setParent_id(cldHouseNode.get("parent_id").asText());														
										}
										if(cldHouseNode.has("children")) { // multiple children
											// process children of id=12
											
											// get children of the only child
											
											// 
											List<House> arrList = new ArrayList<House>();
											cldHouse.setChildren(arrList);
											
											JsonNode oneCldNode = cldHouseNode.get("children");
											
										//	if (oneCldNode.size() > 1) { // id=12 has multiple children
												
											//	for (int m=0; m<oneCldNode.size(); m++) {
												//	JsonNode jHNode = cldNode.get(m+""); // process first child
													
													if (oneCldNode.isArray()) {
														
														ArrayNode arrayNode = (ArrayNode)oneCldNode;
														
														for(JsonNode node : arrayNode) {
															
															House ouse = new House();
															arrList.add(ouse);
															
															if(node.has("id")) {														
																ouse.setId(node.get("id").asText());								
															}
															
															if(node.has("title")) {														
																ouse.setTitle(node.get("title").asText());							
															}
															if(node.has("level")) {														
																ouse.setLevel(node.get("level").asText());														
															}
															if(node.has("parent_id")) {														
																ouse.setParent_id(node.get("parent_id").asText());														
															}
														}
														
													}																																
											
										} // end of processing children of id=12
										
									} // end of child house
								}
								
							//}							
								
							}// end of one children
							
						} // end of children
												
				} else {
					//only one house no issue to code
				}				
				
			}
		} else {
			// throw exception: No input data
		}
		
		if (houseMap.size() > 0) {
			try {
				responseJson = objectMapper.writeValueAsString(houseMap.values());
	           
	        } catch (Exception e) {
	            
	        	responseJson = "error---";
	            
	        }
		}
		
		return responseJson;
	}
		
}
