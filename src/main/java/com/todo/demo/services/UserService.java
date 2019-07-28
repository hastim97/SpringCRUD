package com.todo.demo.services;

import com.todo.demo.models.User;
import com.todo.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User add(String name,String email){
        User user=new User(name,email);
        return userRepository.save(user);
    }

    public User update(int id,String name,String email){
        User user=userRepository.findById(id).orElse(null);
        if(user != null){
            user.setName(name);
            user.setEmail(email);
            userRepository.save(user);
        }
        return null;
    }

    public boolean delete(int id){
        User user=userRepository.findById(id).orElse(null);
        if(user != null) {
            userRepository.delete(user);
            return true;
        }
        return false;
    }

    public List<User> showAll(){
        List<User> userList=userRepository.findAll();
        return userList;
    }

    public User findUser(int id){
        User user=userRepository.findById(id).orElse(null);
        return user;
    }
}
