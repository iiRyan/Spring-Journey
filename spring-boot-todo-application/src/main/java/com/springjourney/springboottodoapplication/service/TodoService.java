package com.springjourney.springboottodoapplication.service;

import java.util.List;

import com.springjourney.springboottodoapplication.models.TodoItem;

public interface TodoService {

    List<TodoItem> findAll();

    TodoItem findById(long theId);

    TodoItem save(TodoItem theTodoItem);

    void deleteTodoItem(long theId);
}
