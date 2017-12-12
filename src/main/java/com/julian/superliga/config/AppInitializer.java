package com.julian.superliga.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {

	private static Class<?>[] configurationClasses = new Class<?>[] { AppConfig.class, SecurityConfig.class };

	@Override
	public void onStartup(ServletContext container) throws ServletException {

		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(configurationClasses);

		container.addListener(new HttpSessionEventPublisher());
		container.addListener(new SessionListener());
		container.addListener(new ContextLoaderListener(ctx));

		ctx.setServletContext(container);

		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));

		servlet.setInitParameter("throwExceptionIfNoHandlerFound", "true");

		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}
	

}