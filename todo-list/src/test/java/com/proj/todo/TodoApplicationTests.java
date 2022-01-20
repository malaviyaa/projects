package com.proj.todo;


import com.proj.todo.service.TaskService;
import com.proj.todo.vo.TaskVO;

import org.junit.Assert;

import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodoApplicationTests {

	@Autowired
	TaskService taskService;


	@Test
	void test_save() {
		taskService.addTask(new TaskVO());
		Assert.assertEquals(1,taskService.findAll().size());
	}

}
