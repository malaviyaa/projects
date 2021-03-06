package com.proj.todo.controller;

import com.proj.todo.entity.Task;
import com.proj.todo.service.TaskService;
import com.proj.todo.vo.TaskVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * crossOrigin was required
 * as angular app was not able to call the controller
 * */

@RestController
@RequestMapping("/todo")
@CrossOrigin
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public void addTask(@RequestBody TaskVO taskVO) {

        taskService.addTask(taskVO);
    }

    @GetMapping("/remove/{taskId}")
    public void removeTask(@PathVariable(value="taskId") String taskId) {
        Long id = Long.parseLong(taskId);
        taskService.removeTask(id);
    }

    @GetMapping("/update/{taskId}/{userid}")
    public void updateTask(@PathVariable(value="taskId") String taskId,
                                   @PathVariable(value="userid") String userid
                                 ) {
        Long id = Long.parseLong(taskId);
        Long uid = Long.parseLong(userid);
        taskService.updateTask(id,uid);
    }

    @GetMapping("/")
    @ResponseBody
    public List<Task> homePage() {
        return taskService.findAll();
    }


}
