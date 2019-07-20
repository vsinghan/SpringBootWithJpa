package com.cg.frs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
@ComponentScan(basePackages = "com.cg")
// @ComponentScan(basePackages = {
// "com.cg.frs.controller","com.cg.frs.dao","com.cg.frs.dto","com.cg.frs.exception","com.cg.frs.service","com.cg.frs.service.impl"}
// )
public class FrsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(FrsApplication.class, args);

		DispatcherServlet dispatcherServlet = (DispatcherServlet) ctx.getBean("dispatcherServlet");
		dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
	}
}
