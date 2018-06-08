package de.drippinger.archunit;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

/**
 * Tests for Layer.
 *
 * @author Dennis Rippinger
 */
public class LayerRule {

	@Test
	public void layer_test() {
		JavaClasses importedClasses = new ClassFileImporter().importPackages("de.drippinger");

		ArchRule rule = noClasses()
				.that()
				.resideInAnyPackage("..ui..")
				.should()
				.accessClassesThat()
				.resideInAnyPackage("..persistence..");

		rule.check(importedClasses);
	}

	@Test
	public void layered_architecture_test() {
		JavaClasses importedClasses = new ClassFileImporter().importPackages("de.drippinger");

		layeredArchitecture()

				.layer("UI").definedBy("de.drippinger.layer.ui..")
				.layer("Services").definedBy("de.drippinger.layer.service..")
				.layer("Persistence").definedBy("de.drippinger.layer.persistence..")

				.whereLayer("UI").mayNotBeAccessedByAnyLayer()
				.whereLayer("Services").mayOnlyBeAccessedByLayers("UI")
				.whereLayer("Persistence").mayOnlyBeAccessedByLayers("Services")

				.check(importedClasses);
	}

}
