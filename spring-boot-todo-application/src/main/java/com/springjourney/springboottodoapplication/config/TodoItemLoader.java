
package com.springjourney.springboottodoapplication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springjourney.springboottodoapplication.models.TodoItem;
import com.springjourney.springboottodoapplication.repository.TodoItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class TodoItemLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(TodoItemLoader.class);

    @Autowired
    TodoItemRepository todoItemRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    private void loadSeedData() {
        if (todoItemRepository.count() == 0) {

            TodoItem todoItem1 = new TodoItem("get the milk");
            TodoItem todoItem2 = new TodoItem("bring your Laundry");
            TodoItem todoItem3 = new TodoItem("learn more about SpringMVC");

            todoItemRepository.save(todoItem1);
            todoItemRepository.save(todoItem2);
            todoItemRepository.save(todoItem3);

        }

        logger.info("Number of TodoItems: {}", todoItemRepository.count());
    }
}
