package com.yojulab.toy_servlets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class ToyServletsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToyServletsApplication.class, args);
	}

}
