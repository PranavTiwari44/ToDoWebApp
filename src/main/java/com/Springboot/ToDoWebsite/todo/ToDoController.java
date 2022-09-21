package com.Springboot.ToDoWebsite.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

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
        List<Todo> todos = toDoService.findToDOByUsername("udemy");
        model.addAttribute("todos", todos);
        return "listTodos";
    }
    @RequestMapping(value = "add-todos", method = RequestMethod.GET)
    public String showNewToDoPage() {
        return "todo";
    }

    @RequestMapping(value = "add-todos", method = RequestMethod.POST)
    public String addNewToDo() {
        return "redirect:list-todos";
    }

}
