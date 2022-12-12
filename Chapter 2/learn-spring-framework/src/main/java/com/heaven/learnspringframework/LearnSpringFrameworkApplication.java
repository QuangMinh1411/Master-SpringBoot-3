package com.heaven.learnspringframework;

import com.heaven.learnspringframework.game.AppGamingBasic;
import com.heaven.learnspringframework.game.GameRunner;
import com.heaven.learnspringframework.game.GamingConsole;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

    public static void main(String[] args) {
//        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
//
//        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
//        System.out.println(context.getBean("name"));
//        System.out.println(context.getBean("age"));
//        System.out.println(context.getBean("person"));
//        System.out.println(context.getBean(Address.class));
//
//        System.out.println(context.getBean("person2MethodCall"));
//        System.out.println(context.getBean("person3"));


        var context = new AnnotationConfigApplicationContext(AppGamingBasic.class);
        context.getBean(GamingConsole.class).up();
        context.getBean(GameRunner.class).run();
    }

}
