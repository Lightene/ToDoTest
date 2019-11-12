package com.todo.back.service;

import com.todo.back.dto.ListDto;
import com.todo.back.mapper.ListMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ListServiceImpl implements ListService {

    Logger logs = LoggerFactory.getLogger(this.getClass());

    @Autowired private ListMapper listMapper;

    @Override
    public String getListAll() {
        try{
            String list = listMapper.getListAll();

            System.out.println(list);

            return list;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public int postList(String title) {
        try {
            int check = listMapper.postList(title);
            System.out.println(check+"serviceImpl");
            return check;
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public int putList(int idx, String title) {
        try {
            HashMap <String, Object> lst = new HashMap<>();
            lst.put("idx",idx);
            lst.put("title",title);
            int result = listMapper.putList(lst);

            System.out.println(result);

            return result;
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public int putListCheck(int idx, boolean check) {
        try {
            HashMap <String, Object> lst = new HashMap<>();
            lst.put("idx",idx);
            lst.put("check",check);
            int result = listMapper.putListCheck(lst);

            return result;
        }catch (Exception e){

            return 0;
        }
    }

    @Override
    public int deleteList(int idx) {
        try {
            return listMapper.deleteList(idx);
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }
}
