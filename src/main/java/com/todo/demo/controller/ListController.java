package com.todo.demo.controller;

import com.todo.demo.models.List;
import com.todo.demo.repositories.ListRepository;
import com.todo.demo.services.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/list")
public class ListController {
    @Autowired
    private ListService listService;

    @PostMapping("/add")
    public ResponseEntity<?> addList(@RequestBody ListTemp listTemp){
//        System.out.println("listTemp = " + listTemp);
        List list=listService.addList(listTemp.getListName(),listTemp.getUserId());
        return ResponseEntity.ok(list);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateList(@RequestBody ListTemp listTemp,@PathVariable("id") int id){
        List list=listService.updateList(id,listTemp.getListName(),listTemp.getUserId());
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteList(@PathVariable("id") int id){
        boolean result=listService.deleteList(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<?> showAllLists(@PathVariable("id") int userId){
        Set<List> lists=listService.showAllLists(userId);
        System.out.println("lists = " + lists);
        return ResponseEntity.ok(lists);
    }

    static class ListTemp{
        String listName;
        int userId;

        public ListTemp(){}

        @Override
        public String toString() {
            return "ListTemp{" +
                    "listName='" + listName + '\'' +
                    ", userId=" + userId +
                    '}';
        }

        public String getListName() {
            return listName;
        }

        public void setListName(String listName) {
            this.listName = listName;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
