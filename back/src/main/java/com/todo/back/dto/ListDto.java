package com.todo.back.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ListDto {
    @ApiModelProperty(value = "리스트 인덱스")
    private int idx;

    @ApiModelProperty(value = "리스트 이름")
    private String title;

    @ApiModelProperty(value = "입력일")
    private Date  DateInserted;
}
