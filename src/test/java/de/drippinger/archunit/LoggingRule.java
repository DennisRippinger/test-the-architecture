package de.drippinger.archunit;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.JavaMethodCall;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

/**
 * LoggingRule
 *
 * @author Dennis Rippinger
 */
@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "de.drippinger")
public class LoggingRule {

	@ArchTest
	public static final ArchRule LOGGING_AND_HISTRIX = noClasses()
			.that()
			.areAnnotatedWith("de.drippinger.aspect.LoggingAnnotation")
			.should()
			.callMethodWhere(hystrixAnnotationIsPresent())
			.because("Hystrix and Loggable Aspects do not work together with default Spring AOP");

	/**
	 * Hystrix and our custom Logging framework are both Aspects which will cause together an exclusion.
	 *
	 * @return
	 */
	static DescribedPredicate<JavaMethodCall> hystrixAnnotationIsPresent() {
		return new DescribedPredicate<JavaMethodCall>("Hystrix annotation is present") {
			@Override
			public boolean apply(JavaMethodCall javaMethodCall) {
				return javaMethodCall
						.getOrigin()
						.isAnnotatedWith(HystrixCommand.class);
			}
		};
	}
}
