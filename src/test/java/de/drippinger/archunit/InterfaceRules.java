package de.drippinger.archunit;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

/**
 * TestArchitecture
 *
 * @author Dennis Rippinger
 */
public class InterfaceRules {

	@Test
	public void interfaces_rule() {
		JavaClasses importedClasses = new ClassFileImporter().importPackages("de.drippinger");

		ArchRule rule = classes()
				.that()
				.resideInAnyPackage("..impl..")
				.should()
				.notBeInterfaces();

		rule.check(importedClasses);
	}

}
