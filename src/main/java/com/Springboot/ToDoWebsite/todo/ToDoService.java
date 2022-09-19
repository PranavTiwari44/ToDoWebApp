package com.Springboot.ToDoWebsite.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {
    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(1, "Udemy", "Learn Spring Boot in 100 Steps - No 1 Java Framework", LocalDate.now().plusDays(10), false));
        todos.add(new Todo(2, "Udemy", "The Complete Javascript Course for Developers", LocalDate.now().plusMonths(1), false));
        todos.add(new Todo(3, "Udemy", "HTML and CSS Masterclass", LocalDate.now().plusMonths(2), false));
    }

    public List<Todo> findToDOByUsername(String username){
        return todos;
    }
}
