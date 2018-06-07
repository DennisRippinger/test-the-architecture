package de.drippinger.archunit;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.core.domain.JavaCall.Predicates.target;
import static com.tngtech.archunit.core.domain.JavaClass.Predicates.assignableTo;
import static com.tngtech.archunit.core.domain.properties.HasName.Predicates.name;
import static com.tngtech.archunit.core.domain.properties.HasOwner.Predicates.With.owner;
import static com.tngtech.archunit.lang.conditions.ArchConditions.callMethodWhere;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

/**
 * ForbiddenApiCall
 *
 * @author Dennis Rippinger
 */
@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "de.drippinger")
public class ForbiddenApiCall {

	@ArchTest
	public static final ArchRule LOGGING_GREATER_INFO_SHOULD_USE_CUSTOM_LOGGER = noClasses()
			.should(
					callMethodWhere(target(owner(assignableTo("org.slf4j.Logger")))
							.and(target(name("warn")))
							.or(target(name("error")))
							.or(target(name("fatal"))))
			)
			.because("One should use our custom logger with defined log messages");

}
