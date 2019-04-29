package com.gshepur.archunitexample.architecture;

import com.gshepur.archunitexample.methodannotation.Call;
import com.gshepur.archunitexample.tasks.RequestKeyAware;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.Test;

import java.util.concurrent.Callable;

public class CheckLayerTest {

    @Test
    public void testNoCallFromServiceToController(){

        JavaClasses classes = new ClassFileImporter().importPackages("com.gshepur.archunitexample");

        ArchRule rule = ArchRuleDefinition.noClasses()
                .that().resideInAPackage("..service..")
                .should().accessClassesThat().resideInAPackage("..api..");

        rule.check(classes);
    }

    @Test
    public void testNoCallFromServiceToControllerFail(){

        JavaClasses classes = new ClassFileImporter().importPackages("com.gshepur.archunitexample");

        ArchRule rule = ArchRuleDefinition.noClasses()
                .that().resideInAPackage("com.gshepur.archunitexample.service")
                .should().accessClassesThat().resideInAPackage("com.gshepur.archunitexample.api");

        rule.check(classes);
    }

    @Test
    public void testCallableTasksAlsoImplementRequestKeyAware(){

        JavaClasses classes = new ClassFileImporter().importPackages("com.gshepur.archunitexample");

//        ArchRule rule = ArchRuleDefinition.classes()
//                .that().areAssignableTo(Callable.class).should().implement(RequestKeyAware.class);
        ArchRule rule = ArchRuleDefinition.classes()
                .that().implement(Callable.class).should().implement(RequestKeyAware.class);

        rule.check(classes);
    }

    @Test
    public void testMethods1(){

        JavaClasses classes = new ClassFileImporter().importPackages("com.gshepur.archunitexample");

        ArchRule rule = ArchRuleDefinition.methods()
                .that().areDeclaredInClassesThat().areAssignableTo(Callable.class).and().haveName("call").should().beAnnotatedWith(Call.class);

        rule.check(classes);
    }

    @Test
    public void testFields1(){

        JavaClasses classes = new ClassFileImporter().importPackages("com.gshepur.archunitexample");

        ArchRule rule = ArchRuleDefinition.fields()
                .that().areDeclaredInClassesThat().areAssignableTo(Callable.class).and().haveName("call").should().beAnnotatedWith(Call.class);

        rule.check(classes);
    }
}
