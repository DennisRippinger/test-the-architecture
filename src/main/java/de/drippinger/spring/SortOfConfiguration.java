package de.drippinger.spring;

import org.springframework.context.annotation.Bean;

/**
 * The JQA Spring Rule triggers here, because we use @{@link Bean} outside of a @Configuration Class.
 *
 * @author Dennis Rippinger
 */
public class SortOfConfiguration {

    @Bean
	public String buildConfig() {
		return "Test";
	}

}
