package com.proj.todo;


import com.proj.todo.entity.Task;
import com.proj.todo.repository.TaskRepo;
import com.proj.todo.service.TaskService;
import com.proj.todo.vo.TaskVO;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
