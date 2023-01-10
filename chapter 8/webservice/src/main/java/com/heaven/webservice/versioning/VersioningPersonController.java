package com.heaven.webservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class VersioningPersonController {
    @GetMapping("v1/person")
    public PersonV1 getFirsVersionOfPerson(){
        return new PersonV1("Bob Charlie");
    }
    @GetMapping("v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2(new Name("Bol","Charlie"));
    }
}
