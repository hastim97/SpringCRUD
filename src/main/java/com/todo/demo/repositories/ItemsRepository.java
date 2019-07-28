package com.todo.demo.repositories;

import com.todo.demo.models.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Items,Integer>{

}
