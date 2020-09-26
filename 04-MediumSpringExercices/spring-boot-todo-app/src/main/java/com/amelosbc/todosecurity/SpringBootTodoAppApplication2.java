package com.amelosbc.todosecurity;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

import com.amelosbc.todosecurity.domain.Todo;
import com.amelosbc.todosecurity.repository.TodoRepository;


@SpringBootApplication
@Profile("prod")
public class SpringBootTodoAppApplication2 implements CommandLineRunner {

	@Autowired
	public TodoRepository todoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootTodoAppApplication2.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Collection<Todo> todos = Arrays.asList(
				new Todo("Learn Spring", "Yes"), 
				new Todo("Learn Driving", "No"), 
				new Todo("Go for a Walk", "No"), 
				new Todo("Cook Dinner", "Yes"),
				new Todo("Learn2 Spring2", "Yes"), 
				new Todo("Learn2 Driving2", "No"), 
				new Todo("Go2 for a Walk2", "No"), 
				new Todo("Cook2 Dinner2", "Yes"));
		
		todos.forEach(todoRepository::save);
		
	}
}
