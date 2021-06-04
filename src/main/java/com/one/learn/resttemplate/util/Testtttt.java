package com.one.learn.resttemplate.util;

public class Testtttt {


    public static void main(String[] args) {
        int code = EnumOne.FORGET_PASSWORD.getCode();
        String deliver = EnumOne.REGISTER.deliver(0);
        System.out.println(deliver);
    }
}
