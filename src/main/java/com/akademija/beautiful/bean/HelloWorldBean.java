package com.akademija.beautiful.bean;

import org.springframework.beans.factory.annotation.Autowired;

//DI Dependency Injection
public class HelloWorldBean {

    private String message;
    //DI preko konstruktora
    private SecondBean secondBean;
    @Autowired
    private ThirdBean thirdBean;
    public HelloWorldBean(SecondBean secondBean){
        this.secondBean = secondBean;
    }

    public String getMessage() {
        return "Message: " + message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SecondBean getSecondBean() {
        return secondBean;
    }

    public void setSecondBean(SecondBean secondBean) {
        this.secondBean = secondBean;
    }
}
