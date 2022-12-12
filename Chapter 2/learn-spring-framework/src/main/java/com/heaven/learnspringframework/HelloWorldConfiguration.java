package com.heaven.learnspringframework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Address(String firstLine,String city){};
record Person(String name,int age, Address address){};
@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String name(){
        return "Sir Quang";
    }
    @Bean
    public int age(){
        return 36;
    }
    @Bean
    public Person person(){
        var person = new Person("Quang",36,new Address("London","LD"));

        return person;
    }
    @Bean(name = "address 2")
    @Primary
    public Address address(){
        return new Address("LA","Miami");
    }

    @Bean

    public Person person2MethodCall(){
        return new Person(name(),age(),address());
    }
    @Bean
    public Person person3(String name,int age,@Qualifier("address3qualifier") Address address3){
        return new Person(name,age,address3);
    }

    @Bean
    @Qualifier("address3qualifier")
    public Address address3(){
        return new Address("Hanoi","VN");
    }
}
