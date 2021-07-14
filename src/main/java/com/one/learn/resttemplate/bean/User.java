package com.one.learn.resttemplate.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    @Size(max = 5)
    private String name;
    @Max(50)
    private int  age;


}