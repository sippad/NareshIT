package com.nit.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.nit.config.RootAppConfig;
import com.nit.config.WebMvcConfig;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext sc) throws ServletException {
		
		AnnotationConfigWebApplicationContext rootCtx = new AnnotationConfigWebApplicationContext();
		AnnotationConfigWebApplicationContext childCtx = new AnnotationConfigWebApplicationContext();
		
		rootCtx.register(RootAppConfig.class);
		childCtx.register(WebMvcConfig.class);
		
		sc.addListener(new ContextLoaderListener(rootCtx));
		ServletRegistration.Dynamic register = sc.addServlet("dispatcher",new DispatcherServlet(childCtx));
		
		register.setLoadOnStartup(2);
		register.addMapping("*.htm");
				
	}
}
