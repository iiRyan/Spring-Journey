package com.springjourney.springboottodoapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springjourney.springboottodoapplication.models.TodoItem;
import com.springjourney.springboottodoapplication.repository.TodoItemRepository;

@Service
public class TodoServiceImpl implements TodoService {

    // inject TodoItem
    private TodoItemRepository itemRepository;

    public TodoServiceImpl(TodoItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<TodoItem> findAll() {

        return itemRepository.findAll();
    }

    @Override
    public TodoItem findById(long theId) {

        Optional<TodoItem> result = itemRepository.findById(theId);

        TodoItem theTodoItem = null;
        if (result.isPresent()) {
            theTodoItem = result.get();
        } else {
            throw new RuntimeException("Did not finde employee 0d - " + theId);
        }
        return theTodoItem;

    }

    @Override
    public TodoItem save(TodoItem theTodoItem) {

        return itemRepository.save(theTodoItem);
    }

    @Override
    public void deleteTodoItem(long theId) {
        itemRepository.deleteById(theId);
    }

}
