package de.drippinger.aspect;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * Aspect
 *
 * @author Dennis Rippinger
 */
@LoggingAnnotation
public class Aspect {

	@HystrixCommand
	public void doCallOverHystrix() {
		System.out.println("Hello from Hystrix");
	}

}
