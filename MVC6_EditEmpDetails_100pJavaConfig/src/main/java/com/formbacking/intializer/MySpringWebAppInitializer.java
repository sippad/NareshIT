package com.formbacking.intializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.formbacking.config.RootAppConfig;
import com.formbacking.config.WebMvcConfig;

public class MySpringWebAppInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {		
		
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		AnnotationConfigWebApplicationContext webMvcContext = new AnnotationConfigWebApplicationContext();
		
		rootContext.register(RootAppConfig.class);
		webMvcContext.register(WebMvcConfig.class);
		
		ContextLoaderListener listener = new ContextLoaderListener(rootContext);
		DispatcherServlet dispatcher = new DispatcherServlet(webMvcContext);
		
		servletContext.addListener(listener);
		
		ServletRegistration.Dynamic registration = servletContext.addServlet("dispatc",dispatcher);
		registration.setLoadOnStartup(2);
		registration.addMapping("*.htm");		
	}

}
