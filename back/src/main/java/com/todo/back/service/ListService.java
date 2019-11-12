package com.todo.back.service;

public interface ListService {
    String getListAll();
    int postList(String title);
    int putList(int idx, String title);
    int putListCheck(int idx, boolean check);
    int deleteList(int idx);
}
