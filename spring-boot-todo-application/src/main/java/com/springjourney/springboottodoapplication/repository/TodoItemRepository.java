package com.springjourney.springboottodoapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.springjourney.springboottodoapplication.models.TodoItem;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {

}
