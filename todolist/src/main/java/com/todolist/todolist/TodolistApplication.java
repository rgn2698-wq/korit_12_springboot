package com.todolist.todolist;

import com.todolist.todolist.domain.Todo;
import com.todolist.todolist.domain.User;
import com.todolist.todolist.repository.TodoRepository;
import com.todolist.todolist.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
@RequiredArgsConstructor
public class TodolistApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(TodolistApplication.class);

	private final UserRepository userRepository;
	private final TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("성공적으로 실행 진행중입니다.");

		User user1 = new User("김일", "1234", "USER");
		User user2 = new User("김이", "1234", "ADMIN");
		userRepository.saveAll(Arrays.asList(user1, user2));

		Todo todo1 = new Todo("SQLD", user1);
		Todo todo2 = new Todo("자습", user2);
		todoRepository.saveAll(Arrays.asList(todo1, todo2));


	}
}
