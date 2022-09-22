package com.Springboot.ToDoWebsite.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class ToDoController {

    private ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @RequestMapping("list-todos")
    public String listAllToDos(ModelMap model) {
        List<Todo> todos = toDoService.findToDoByUsername("udemy");
        model.addAttribute("todos", todos);
        return "listTodos";
    }
    @RequestMapping(value = "add-todos", method = RequestMethod.GET)
    public String showNewToDoPage(ModelMap model) {
        Todo todo = new Todo(0, (String)model.get("name"), "", LocalDate.now().plusMonths(1), false);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "add-todos", method = RequestMethod.POST)
    public String addNewToDo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()){
            return "todo";
        }
        toDoService.addTodo((String)model.get("name"), todo.getDescription(), LocalDate.now().plusMonths(1), false);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "delete-todo")
    public String deleteToDo(@RequestParam int id) {
        toDoService.deleteTodoById(id);
        return "redirect:list-todos";
    }

}
