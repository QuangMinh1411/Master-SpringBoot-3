package com.heaven.webservice.versioning;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonV1 {
    String name;
    public PersonV1(String name) {
        this.name=name;
    }
}
