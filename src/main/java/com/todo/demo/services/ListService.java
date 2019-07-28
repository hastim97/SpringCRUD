package com.todo.demo.services;

import com.todo.demo.models.List;
import com.todo.demo.models.User;
import com.todo.demo.repositories.ListRepository;
import com.todo.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ListService {
    @Autowired
    private ListRepository listRepository;

    @Autowired
    private UserRepository userRepository;

    public User createUserObject(int id){
        return userRepository.findById(id).orElse(null);
    }

    public List addList(String listName,int userId){
        User user=createUserObject(userId);
        List list=new List(listName,user);
        return listRepository.save(list);
    }

    public List updateList(int id,String listName,int userId){
        List list=listRepository.findById(id).orElse(null);
        if(list != null){
            list.setListName(listName);
            list.setUser(createUserObject(userId));
            return listRepository.save(list);
        }
        return null;
    }

    public boolean deleteList(int id){
        List list=listRepository.findById(id).orElse(null);
        if(list != null){
            listRepository.delete(list);
            return true;
        }
        return false;
    }

    public Set<List> showAllLists(int userId){
        User user=userRepository.findById(userId).orElse(null);
        Set<List> lists=listRepository.findAllByUser(user);
        return lists;
    }
}
