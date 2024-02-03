package com.springjourney.springboottodoapplication.controllers;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springjourney.springboottodoapplication.models.TodoItem;
import com.springjourney.springboottodoapplication.repository.TodoItemRepository;

import jakarta.validation.Valid;

@Controller
public class TodoItemController {

    private final Logger logger = LoggerFactory.getLogger(TodoItemController.class);

    @Autowired
    private TodoItemRepository itemRepository;

    @GetMapping("/")
    public ModelAndView index() {
        logger.info("request to GET index");

        // Set the view name in the constructor.
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", itemRepository.findAll());

        return modelAndView;
    }

    @PostMapping("/todo/{id}")
    public String updateTodoItem(@PathVariable("id") long id, @Valid TodoItem todoItem, BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            todoItem.setId(id);
            return "update-todo-item";
        }

        todoItem.setModifiedDate(Instant.now());
        itemRepository.save(todoItem);
        return "redirect:/";
    }
}
