package com.one.learn.resttemplate.test;

import java.util.ArrayList;
import java.util.List;

public class MyTest {


    public static  <T extends Fruit> Fruit getFruit(T t) {
        return t;
    }

    public static void main(String[] args) {
        //下界
        //只能是Fruit或者是Fruit的子集
        getFruit(new Apple());
        getFruit(new Fruit());
        //getFruit(new Circle());
        //上界
        List<? super Apple> list = new ArrayList<>();
        list.add(new Apple());
        //list.add(new Fruit());
     //  list.add(new Circle());
    }


}
