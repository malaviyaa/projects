package com.proj.todo.service;

import com.proj.todo.entity.Task;
import com.proj.todo.repository.TaskRepo;
import com.proj.todo.vo.TaskVO;
import lombok.extern.slf4j.XSlf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    Logger logger = LoggerFactory.getLogger(TaskService.class);
    @Autowired
    private TaskRepo taskRepo;

    @Transactional
    public void addTask(TaskVO task) {
        try {
            logger.debug(" isnide save ");
            Task taskDb = new Task();
            taskDb.setDescription(task.getDescription());
            taskDb.setStatus(task.isStatus());
            taskDb.setUpdatedDate(new Date());
            taskDb.setUserid(task.getUserid());
            taskRepo.save(taskDb);
        } catch(Exception e) {
            logger.error("error while adding todo "+e.getMessage());
        }
    }

    @Transactional
    public void updateTask(Long taskid,Long userId) {
        try {
            Task taskDb = taskRepo.findById(taskid).get();
            if(taskDb !=null && taskDb.getUserid() == userId) {
                taskDb.setStatus(!taskDb.isStatus());
                taskDb.setUpdatedDate(new Date());
            }

            taskRepo.save(taskDb);
        } catch(Exception e) {
            logger.error("error while updating todo "+e.getMessage());
        }
    }

    @Transactional
    public void removeTask(Long id) {
        try {
        taskRepo.deleteById(id);
        } catch(Exception e) {
            logger.error("error while removing todo "+e.getMessage());
        }
    }

    public List<Task> findAll() {
        return  taskRepo.findAll();
    }
}
