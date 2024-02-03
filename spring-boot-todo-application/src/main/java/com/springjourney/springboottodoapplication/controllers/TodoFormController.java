package com.springjourney.springboottodoapplication.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springjourney.springboottodoapplication.models.TodoItem;
import com.springjourney.springboottodoapplication.repository.TodoItemRepository;

@Controller
public class TodoFormController {

    private final Logger logger = LoggerFactory.getLogger(TodoFormController.class);

    @Autowired
    private TodoItemRepository itemRepository;

    @GetMapping("/edit/{id}") // @RequestParam("id") long theId, Model theModel
    public String showUpdateForm(@PathVariable("id") long theId, Model theModel) {

        TodoItem todoItem = itemRepository.findById(theId)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + theId + " not found!"));

        theModel.addAttribute("todo", todoItem);

        return "update-todo-item";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") long theId, Model theModel) {

        TodoItem todoItem = itemRepository.findById(theId)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + theId + " not found!"));

        itemRepository.delete(todoItem);

        return "redirect:/";

    }
}
