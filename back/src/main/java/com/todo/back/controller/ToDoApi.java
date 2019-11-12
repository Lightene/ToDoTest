package com.todo.back.controller;


import com.todo.back.common.ResponseStatus;
import com.todo.back.service.ListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Api("ToDo List api")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/todo")
public class ToDoApi {

    Logger logs = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ListService listService;

    @ApiOperation(value = "list 전체 조회")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getTodoList(){
        try{
            logs.trace("========== 리스트 조회 ==========");

            String list = listService.getListAll();

            return list;

        }catch (Exception e){
            System.out.println(e);
            return e.toString();
        }
    }

    @ApiOperation(value = "list 생성")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public int postTodoList(@ApiParam(value = "리스트 제목") @RequestBody HashMap<String,String> map){
        try{
            logs.trace("========== 리스트 생성 ==========");
            System.out.println(map.get("title")+"API");
            return listService.postList(map.get("title"));

        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }

    @ApiOperation(value = "list 수정")
    @RequestMapping(value = "/list", method = RequestMethod.PUT)
    public int putTodoList(@ApiParam(value = "리스트 인덱스") @RequestParam(value = "idx") String idx,
                              @ApiParam(value = "리스트 제목") @RequestParam(value = "title") String title){
        try{
            logs.trace("========== 리스트 수정 ==========");
            System.out.println(title);

            return listService.putList(Integer.parseInt(idx),title);

        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }

    @ApiOperation(value = "list check 수정")
    @RequestMapping(value = "/list/check", method = RequestMethod.PUT)
    public int putTodoListCheck(@ApiParam(value = "리스트 인덱스") @RequestParam(value = "idx") String idx,
                           @ApiParam(value = "리스트 체크 상태") @RequestParam(value = "check") boolean check){
        try{
            logs.trace("========== 리스트 체크 수정 ==========");
            System.out.println(check);

            return listService.putListCheck(Integer.parseInt(idx),check);

        }catch (Exception e){
            System.out.println(e);
            return 0;

        }
    }

    @ApiOperation(value = "list 삭제")
    @RequestMapping(value = "/list/{idx}", method = RequestMethod.DELETE)
    public int deleteTodoList(@ApiParam(value = "리스트 인덱스") @PathVariable int idx){
        try{
            logs.trace("========== 리스트 삭제 ==========");

            return listService.deleteList(idx);

        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }
}
