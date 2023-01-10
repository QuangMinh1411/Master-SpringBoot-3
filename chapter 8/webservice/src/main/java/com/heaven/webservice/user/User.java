package com.heaven.webservice.user;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    @Size(min = 2,message = "Name should at least 2 characters")
    @JsonProperty("user_name")
    private String name;
    @Past(message = "BirthDate should be in past")
    @JsonProperty("birth_date")
    private LocalDate birthDate;
}
