package com.akademija.beautiful.bean.config;

import com.akademija.beautiful.bean.HelloWorldBean;
import com.akademija.beautiful.bean.SecondBean;
import com.akademija.beautiful.bean.ThirdBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {

    @Bean(name = "vozdraBean")
    @Scope("singleton")
    public HelloWorldBean getHelloWorldBean(SecondBean secondBean){
        return new HelloWorldBean(secondBean);
    }

    @Bean(name = "drugiBean")
    @Scope("prototype")
    public SecondBean secondBean(){
        return new SecondBean();
    }

    @Bean
    public ThirdBean thirdBean(){
        return new ThirdBean();
    }
}
