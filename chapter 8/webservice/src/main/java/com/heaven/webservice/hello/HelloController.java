package com.heaven.webservice.hello;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloController {
    private MessageSource messageSource;

    public HelloController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello world!";
    }
    @GetMapping("/bean-hello")
    public HelloBean helloBean(){
        return new HelloBean("Hello");
    }
    @GetMapping("/hello/{name}")
    public HelloBean helloWorld(@PathVariable("name") String name){
        return new HelloBean("Hello " + name);
    }

    @GetMapping("/hello-inter")
    public String helloInternational(){
        Locale locale = LocaleContextHolder.getLocale();
       return messageSource.getMessage("good.morning.message",null,
                "Default Message",locale);

    }
}
