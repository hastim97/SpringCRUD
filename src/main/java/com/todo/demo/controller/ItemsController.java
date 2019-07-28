package com.todo.demo.controller;

import com.todo.demo.models.Items;
import com.todo.demo.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;

@RestController
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    ItemsService itemsService;

    @PostMapping("/add/{id}")
    public ResponseEntity<?> addItems(@PathVariable("id") int id, @RequestBody ItemsTemp itemsTemp){
        System.out.println("itemsTemp = " + itemsTemp);
        System.out.println("id = " + id);
        Items item=itemsService.addItems(id, itemsTemp.getData(), 0);
        return ResponseEntity.ok(item);
    }

    @PutMapping("/check/{id}")
    public ResponseEntity<?> checkItem(@PathVariable("id") int id){
        Items item=itemsService.checkItem(id);
        return ResponseEntity.ok(item);
    }

    @GetMapping("/getData/{id}")
    public ResponseEntity<?> getData(@PathVariable("id") int id){
        Items item=itemsService.getData(id);
        System.out.println("item = " + item);
        return ResponseEntity.ok(item);
    }

    static class ItemsTemp{
        String data;

        public ItemsTemp(){}

        public ItemsTemp(String data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "ItemsTemp{" +
                    "data='" + data + '\'' +
                    '}';
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

    }
}
