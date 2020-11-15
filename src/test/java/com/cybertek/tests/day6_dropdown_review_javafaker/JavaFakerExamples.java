package com.cybertek.tests.day6_dropdown_review_javafaker;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerExamples {

    @Test
    public void faker_test(){
        Faker faker =new Faker();
        String firstName=faker.name().firstName();

        System.out.println(firstName);

        System.out.println("full name = " + faker.name().fullName());

        System.out.println("faker.artist().name() = " + faker.artist().name());
        System.out.println("faker.address().country() = " + faker.address().country());
        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact());
        System.out.println("faker.ancient().hero() = " + faker.app().name());


    }
}
