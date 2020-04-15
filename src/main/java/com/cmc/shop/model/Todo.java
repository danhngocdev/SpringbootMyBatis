package com.cmc.shop.model;

public class Todo {
	private int id;
	private String title;
	private String todo_type;
	public Todo() {
		// TODO Auto-generated constructor stub
	}
	
	public Todo(int id,String title, String todo_type) {
		super();
		this.id = id;
		this.title = title;
		this.todo_type = todo_type;
	}
    
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTodo_type() {
		return todo_type;
	}
	public void setTodo_type(String todo_type) {
		this.todo_type = todo_type;
	}


}
