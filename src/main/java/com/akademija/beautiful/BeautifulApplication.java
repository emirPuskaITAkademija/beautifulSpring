package com.akademija.beautiful;

import com.akademija.beautiful.bean.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BeautifulApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeautifulApplication.class, args);
	}


}
