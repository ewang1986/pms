package com.info.util;
/**
 * 对response进行封装
 * @author v-dongdm
 * 2018年5月16日21:46:41
 */
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {
 
    private int status = HttpStatus.OK.value();
 
    private Object content;
    
    public Result() {
    	this.status = HttpStatus.OK.value();
    }
 
    public Result(Object content) {
        this.content = content;
    }
 
    public Result(int status, Object content) {
        this.status = status;
        this.content = content;
    }
 
 
    public int getStatus() {
        return status;
    }
 
    public void setStatus(int status) {
        this.status = status;
    }
 
    public Object getContent() {
        return content;
    }
 
    public void setContent(Object content) {
        this.content = content;
    }
}
