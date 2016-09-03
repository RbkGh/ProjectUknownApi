package com.swiftpot.projectuknown;

import com.swiftpot.projectuknown.filter.JwtFilter;
import com.swiftpot.projectuknown.support.BaseUrlHolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ProjectUknownApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ProjectUknownApplication.class, args);
	}

	/**
	 *
	 * extend SpringBootServletInitializer when war file is needed and override configure method
	 * @param application
	 * @return SpringApplicationBuilder
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ProjectUknownApplication.class);
	}

	@Bean
	public FilterRegistrationBean jwtFilter(){
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns(BaseUrlHolder.BASE_URL_MAIN_ENDPOINT+"/*");
		TypeExcludeFilter typeExcludeFilter = new TypeExcludeFilter();


		return registrationBean;
	}
}
