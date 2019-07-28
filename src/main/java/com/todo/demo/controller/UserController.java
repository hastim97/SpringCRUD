package com.todo.demo.controller;

import com.todo.demo.models.User;
import com.todo.demo.repositories.UserRepository;
import com.todo.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody UserTemp userTemp){
        User user = this.userService.add(userTemp.getName(),userTemp.getEmail());
        return ResponseEntity.ok(user);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@RequestBody UserTemp userTemp, @PathVariable("id") int id){
        User user=this.userService.update(id, userTemp.getName(),userTemp.getEmail());
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id){
        boolean result=this.userService.delete(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/showAll")
    public ResponseEntity<?> showAllUser(){
        List<User> userList=this.userService.showAll();
        System.out.println("userList = " + userList);
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<?> findUser(@PathVariable("id") int id){
        User user=this.userService.findUser(id);
        if(user == null)
            System.out.println("User not found");
        else
            System.out.println("user = " + user);
        return ResponseEntity.ok(user);
    }

    static class UserTemp{
        String name,email;

        public UserTemp(){}

        @Override
        public String toString() {
            return "UserTemp{" +
                    "name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

}
