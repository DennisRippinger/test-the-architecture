package de.drippinger.archunit;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.JavaAnnotation;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

/**
 * ForbiddenTEchnology
 *
 * @author Dennis Rippinger
 */
@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "de.drippinger")
public class ForbiddenTechnology {

	@ArchTest
	public static final ArchRule DOMAIN_SHOULD_NOT_USE_JPA = noClasses()
			.that()
			.resideInAPackage("..domain..")
			.should()
			.beAnnotatedWith(groupOfAnnotations("JPA", "javax.persistence"));


	/**
	 * Creates a {@link DescribedPredicate} for a group of annotation, denoted by the package name.
	 *
	 * @param name              to log an error message with.
	 * @param packageStartsWith package starts with this name.
	 * @return a new DescribedPredicate.
	 */
	static DescribedPredicate<JavaAnnotation> groupOfAnnotations(final String name,
																 final String packageStartsWith) {
		return new DescribedPredicate<JavaAnnotation>(name) {

			@Override
			public boolean apply(JavaAnnotation javaAnnotation) {
				return javaAnnotation.getType().getPackage().startsWith(packageStartsWith);
			}

		};
	}
}
