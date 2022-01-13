package com.proj.todo.controller;

import com.proj.todo.entity.Task;
import com.proj.todo.service.TaskService;
import com.proj.todo.vo.TaskVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public ModelAndView addTask(@ModelAttribute("taskVO") TaskVO taskVO) {

        taskService.addTask(taskVO);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("welcome");
        List<Task> todos = taskService.findAll();
        mav.addObject("taskVO",new TaskVO());
        mav.addObject("todos", todos);
        return mav;

    }

    @RequestMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @GetMapping("/remove/{taskId}")
    public ModelAndView removeTask(@PathVariable(value="taskId") String taskId) {
        Long id = Long.parseLong(taskId);
        taskService.removeTask(id);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("welcome");
        List<Task> todos = taskService.findAll();
        mav.addObject("taskVO",new TaskVO());
        mav.addObject("todos", todos);
        return mav;
    }

    @GetMapping("/update/{taskId}/{status}")
    public ModelAndView updateTask(@PathVariable(value="taskId") String taskId,
                                   @PathVariable(value="userid") String userid,
                                   @PathVariable(value="status") boolean status) {
        Long id = Long.parseLong(taskId);
        Long uid = Long.parseLong(userid);
        taskService.updateTask(id,uid,status);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("welcome");
        List<Task> todos = taskService.findAll();
        mav.addObject("taskVO",new TaskVO());
        mav.addObject("todos", todos);
        return mav;
    }
    @GetMapping("/")
    public ModelAndView homePage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("welcome");
        mav.addObject("taskVO",new TaskVO());
        List<Task> todos = taskService.findAll();

        mav.addObject("todos", todos);
        return mav;
    }


}
