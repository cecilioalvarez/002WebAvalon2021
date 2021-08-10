package com.arquitecturajava.spring;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringInicializador implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext contexto=new AnnotationConfigWebApplicationContext();
		contexto.register(SpringConfigurador.class);
		contexto.setServletContext(servletContext);
		
		ServletRegistration.Dynamic servlet=
				servletContext.addServlet("despachador", new DispatcherServlet(contexto));
		
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}

}