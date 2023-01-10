package com.heaven.webservice.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@JsonFilter("SomeBeanFilter")
public class SomeBean {
    private String field1;
//    @JsonIgnore
    private String field2;

    private String field3;
}
