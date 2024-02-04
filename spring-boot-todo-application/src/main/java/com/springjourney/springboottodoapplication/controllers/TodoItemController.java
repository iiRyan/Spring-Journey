package com.springjourney.springboottodoapplication.controllers;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springjourney.springboottodoapplication.models.TodoItem;
import com.springjourney.springboottodoapplication.repository.Todoservice;
import com.springjourney.springboottodoapplication.service.TodoService;

import jakarta.validation.Valid;

@Controller
public class TodoItemController {

    private final Logger logger = LoggerFactory.getLogger(TodoItemController.class);

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private TodoService service;

    @GetMapping("/")
    public ModelAndView index() {
        logger.info("request to GET index");

        // Set the view name in the constructor.
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", service.findAll());

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
        service.save(todoItem);
        return "redirect:/";
    }

    @PostMapping("/saveTodo")
    public String createTodoItem(@Valid @ModelAttribute("todoItem") TodoItem theTodoItem, BindingResult result) {

        if (result.hasErrors()) {
            return "add-todo-item";
        }

        theTodoItem.setCreatedDate(Instant.now());
        theTodoItem.setModifiedDate(Instant.now());
        service.save(theTodoItem);

        return "redirect:/";
    }
}
