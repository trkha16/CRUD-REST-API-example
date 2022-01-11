package com.test.test.controller;

import java.util.List;

import com.test.test.model.Todo;
import com.test.test.repo.TodoRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @Autowired
    private TodoRepo todoRepo;

    @GetMapping(value = "/todos")
    public List<Todo> getTodos() {
        return todoRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveTodo(@RequestBody Todo todo) {
        todoRepo.save(todo);
        return "Saving...";
    }

    @PutMapping(value = "/update/{id}")
    public String updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        //Todo updateTodo = todoRepo.findById(id).get();
        todoRepo.save(todo);
        return "Updating...";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteTodo(@PathVariable Long id){
        Todo deleteTodo = todoRepo.findById(id).get();
        todoRepo.delete(deleteTodo);
        return "Deleting...";
    }
}
