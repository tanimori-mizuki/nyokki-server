package com.example.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.domain.Todo;
import com.example.mapper.TodoMapper;

@RunWith(MockitoJUnitRunner.class)
public class RegisterTodoServiceTest {
	
	@Mock
	private TodoMapper todoMapper;
	
	@InjectMocks
	private RegisterTodoService registerTodoService;
	
	@Test
	public void 主キーからtodoを取得() {
		Integer todoId=1;
		String task="サンプルタスク1";
		Todo todo = new Todo();
		todo.setId(todoId);
		todo.setTask(task);
		//when(todoMapper.selectByPrimaryKey(any(Integer.class)).thenReturn(todo));
		
		
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
