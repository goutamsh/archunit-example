package com.gshepur.archunitexample.architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.Test;

public class CheckLayerTest {

    @Test
    public void testNoCallFromServiceToController(){

        JavaClasses classes = new ClassFileImporter().importPackages("com.gshepur.archunitexample");

        ArchRule rule = ArchRuleDefinition.noClasses()
                .that().resideInAPackage("com.gshepur.archunitexample.service")
                .should().accessClassesThat().resideInAPackage("com.gshepur.archunitexample.api");

        rule.check(classes);
    }

    @Test
    public void testNoCallFromServiceToControllerFail(){

        JavaClasses classes = new ClassFileImporter().importPackages("com.gshepur.archunitexample");

        ArchRule rule = ArchRuleDefinition.noClasses()
                .that().resideInAPackage("com.gshepur.archunitexample.service")
                .should().accessClassesThat().resideInAPackage("com.gshepur.archunitexample.dao");

        rule.check(classes);
    }
}
