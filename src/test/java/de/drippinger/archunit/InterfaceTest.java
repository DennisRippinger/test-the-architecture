package de.drippinger.archunit;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

/**
 * TEsts if there is an Interface within an impl folder.
 *
 * @author Dennis Rippinger
 */
public class InterfaceTest {

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
