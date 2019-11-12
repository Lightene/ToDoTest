package com.todo.back.mapper;

import com.todo.back.dto.ListDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ListMapper {
    String getListAll();
    int postList(String title);
    int putList(HashMap<String, Object> lst);
    int putListCheck(HashMap<String, Object> lst);
    int deleteList(int idx);
}
