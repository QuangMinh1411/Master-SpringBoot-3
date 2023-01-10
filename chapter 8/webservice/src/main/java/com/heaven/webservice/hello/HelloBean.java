package com.heaven.webservice.hello;

import lombok.Data;

@Data
public class HelloBean {
    private String message;
    public HelloBean(String hello) {
        this.message = hello;
    }
}
