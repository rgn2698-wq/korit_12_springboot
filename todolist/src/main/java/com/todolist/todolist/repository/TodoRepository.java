package com.todolist.todolist.repository;


import com.todolist.todolist.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "todolist")
public interface TodoRepository extends JpaRepository<Todo,Long> {
}
