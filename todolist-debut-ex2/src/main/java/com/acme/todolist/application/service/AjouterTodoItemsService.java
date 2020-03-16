package com.acme.todolist.application.service;

import com.acme.todolist.domain.TodoItem;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.acme.todolist.application.port.in.AjouterTodoItems;
import com.acme.todolist.application.port.out.UpdateTodoItem;

@Component
public class AjouterTodoItemsService implements AjouterTodoItems {
	
	private UpdateTodoItem updateTodoItem;
	
	@Inject
	public AjouterTodoItemsService(UpdateTodoItem updateTodoItem) {
		this.updateTodoItem = updateTodoItem;
	}

	@Override
	public void addTodoItem(TodoItem item) {
		this.updateTodoItem.storeNewTodoItem(item);
	}

}
