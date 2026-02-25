package com.todolist.todolist.repository;

import com.todolist.todolist.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "userlist")
public interface UserRepository extends JpaRepository<User,Long> {
}
