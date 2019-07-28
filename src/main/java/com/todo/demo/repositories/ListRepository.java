package com.todo.demo.repositories;


import com.todo.demo.models.List;
import com.todo.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ListRepository extends JpaRepository<List,Integer> {
    Set<List> findAllByUser(User user);
}
