package de.drippinger.spring;

import org.springframework.context.annotation.Bean;

/**
 * Bean
 *
 * @author Dennis Rippinger
 */
public class SortOfConfiguration {


	@Bean
	public String buildConfig() {
		return "Test";
	}

}
