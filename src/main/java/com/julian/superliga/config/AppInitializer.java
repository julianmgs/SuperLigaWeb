package com.julian.superliga.config;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	private int maxUploadSizeInMb = 5 * 1024 * 1024; // 5 MB
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConfig.class, SecurityConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected void registerDispatcherServlet(ServletContext servletContext) {
		super.registerDispatcherServlet(servletContext);

		servletContext.addListener(new HttpSessionEventPublisher());
		servletContext.addListener(new SessionListener());
	}
	
	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {

		// upload temp file will put here
		File uploadDirectory = new File(System.getProperty("java.io.tmpdir"));

		// register a MultipartConfigElement
		MultipartConfigElement multipartConfigElement = 
				new MultipartConfigElement(uploadDirectory.getAbsolutePath(), 
						maxUploadSizeInMb, maxUploadSizeInMb * 2, maxUploadSizeInMb / 2);

		registration.setMultipartConfig(multipartConfigElement);
        
		registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
	}
}
