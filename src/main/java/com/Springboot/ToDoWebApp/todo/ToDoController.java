package com.Springboot.ToDoWebApp.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

//@Controller
@SessionAttributes("name")
public class ToDoController {

    private ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @RequestMapping("list-todos")
    public String listAllToDos(ModelMap model) {
        String username = getLoggedInUsername(model);
        List<Todo> todos = toDoService.findToDoByUsername(username);
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    @RequestMapping(value = "add-todos", method = RequestMethod.GET)
    public String showNewToDoPage(ModelMap model) {
        Todo todo = new Todo(0, getLoggedInUsername(model), "", LocalDate.now().plusMonths(1), false);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "add-todos", method = RequestMethod.POST)
    public String addNewToDo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()){
            return "todo";
        }
        toDoService.addTodo(getLoggedInUsername(model), todo.getDescription(), todo.getTargetDate(), false);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "delete-todo")
    public String deleteToDo(@RequestParam int id) {
        toDoService.deleteTodoById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateToDoPage(@RequestParam int id, ModelMap model) {
        Todo todo = toDoService.findByID(id);
        model.addAttribute("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateToDo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()){
            return "todo";
        }
        todo.setUsername(getLoggedInUsername(model));
        toDoService.updateTodo(todo);
        return "redirect:list-todos";
    }

    private String getLoggedInUsername(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
