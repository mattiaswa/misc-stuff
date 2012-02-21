package com.scila.web;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/alert")
public class AlertService {
	private List<Todo> todos;
	{
		Todo todo = new Todo();
		todo.setSummary("This is my first todo");
		todo.setDescription("This is my first todo");
		
		Todo todo2 = new Todo();
		todo2.setSummary("This is my second");
		todo2.setDescription("This is descr of my second");
		
		todos = Arrays.asList(todo, todo2);
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Todo> getTodos() {
		return todos;
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Todo getTodo(@PathParam("id") int id) {
		return todos.get(id);
	}
}
