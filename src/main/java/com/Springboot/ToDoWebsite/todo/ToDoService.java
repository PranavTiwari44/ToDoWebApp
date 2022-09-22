package com.Springboot.ToDoWebsite.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class ToDoService {

    private static int todosCount = 0;
    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(++todosCount, "Pranav Tiwari", "Learn Spring Boot in 100 Steps - No 1 Java Framework",
                LocalDate.now().plusDays(10), false));
        todos.add(new Todo(++todosCount, "Pranav Tiwari", "The Complete Javascript Course for Developers",
                LocalDate.now().plusMonths(1), false));
        todos.add(new Todo(++todosCount, "Pranav Tiwari", "HTML and CSS Masterclass",
                LocalDate.now().plusMonths(2), false));
    }

    public List<Todo> findToDoByUsername(String username){
        return todos;
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done){
        Todo todo =  new Todo(++todosCount, username, description, targetDate, done);
        todos.add(todo);
    }

    public void deleteTodoById(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }
}
