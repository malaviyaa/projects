package com.proj.todo.service;

import com.proj.todo.entity.Task;
import com.proj.todo.repository.TaskRepo;
import com.proj.todo.vo.TaskVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepo taskRepo;

    @Transactional
    public void addTask(TaskVO task) {
        Task taskDb = new Task();
        taskDb.setDescription(task.getDescription());
        taskDb.setStatus(task.isStatus());
        taskDb.setUpdatedDate(new Date());
        taskDb.setUserid(task.getUserid());

        taskRepo.save(taskDb);
    }

    @Transactional
    public void updateTask(Long taskid,Long userId) {
        Task taskDb = taskRepo.findById(taskid).get();
        if(taskDb !=null && taskDb.getUserid() == userId) {
            taskDb.setStatus(!taskDb.isStatus());
            taskDb.setUpdatedDate(new Date());
        }

        taskRepo.save(taskDb);
    }

    public void removeTask(Long id) {
        taskRepo.deleteById(id);
    }

    public List<Task> findAll() {

        return  taskRepo.findAll();
    }
}
