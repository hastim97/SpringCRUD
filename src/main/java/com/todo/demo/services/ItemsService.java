package com.todo.demo.services;

import com.todo.demo.models.Items;
import com.todo.demo.models.List;
import com.todo.demo.repositories.ItemsRepository;
import com.todo.demo.repositories.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemsService {
    @Autowired
    ItemsRepository itemsRepository;

    @Autowired
    ListRepository listRepository;

    public List createListObject(int list_id){
        List list = listRepository.findById(list_id).orElse(null);
        System.out.println("list = " + list);
        return list;
    }

    public Items addItems(int list_id,String data,int checked){
        List list = createListObject(list_id);
        Items item=new Items(data,checked,list);
        return itemsRepository.save(item);
    }

    public Items checkItem(int id){
        Items item=itemsRepository.findById(id).orElse(null);
        if(item != null){
            item.setChecked(1);
            return itemsRepository.save(item);
        }
        return null;
    }

    public Items getData(int id){
        Items item=itemsRepository.findById(id).orElse(null);
        return item;
    }
}
