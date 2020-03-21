package com.jimfly.bake.entity.common;

import lombok.Data;

import java.util.List;

@Data
public class PageResponse<T> {
    private Integer code = 0;
    private String msg = "";
    private Long count;
    private List<T> data;

    public static PageResponse getSuccessResponse(List data,Long total){
        PageResponse pr =  new PageResponse<>();
        pr.setData(data);
        pr.setCount(total);
        return pr;
    }
}
