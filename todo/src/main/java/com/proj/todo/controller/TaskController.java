package com.proj.todo.controller;

import com.proj.todo.service.TaskService;
import com.proj.todo.vo.TaskVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public void addTask(@RequestBody TaskVO taskVO) {
        taskService.addTask(taskVO);
    }

    @PostMapping("/remove")
    public void removeTask(@RequestBody TaskVO taskVO) {
        taskService.removeTask(taskVO.getUserid());
    }

}
