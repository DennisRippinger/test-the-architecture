package de.drippinger.archunit;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;


/**
 * Tests if an EntityManager is used outside of persistence.
 */
@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "de.drippinger")
public class EntityManagerRule {

    @ArchTest
    public static final ArchRule only_persistence_may_use_the_EntityManager =
        noClasses()
            .that()
            .resideOutsideOfPackage("..persistence..")
            .should()
            .accessClassesThat()
            .areAssignableTo(javax.persistence.EntityManager.class);
}

