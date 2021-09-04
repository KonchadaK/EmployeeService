package com.mycompany.demo.model;

import java.util.List;

public class House {
	
	String id;
	String title;
	String level;
	List<House> children;
	String parent_id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public List<House> getChildren() {
		return children;
	}
	public void setChildren(List<House> children) {
		this.children = children;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	
	}
