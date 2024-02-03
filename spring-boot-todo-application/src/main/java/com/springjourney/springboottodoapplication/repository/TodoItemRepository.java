package com.springjourney.springboottodoapplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.springjourney.springboottodoapplication.models.TodoItem;

public interface TodoItemRepository extends CrudRepository<TodoItem, Long> {

}
