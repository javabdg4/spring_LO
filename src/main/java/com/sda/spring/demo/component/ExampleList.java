package com.sda.spring.demo.component;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ExampleList {

    public ExampleList(){
        System.out.println("===INFO===");
    }

    public String generate(){

        List<String> list = new ArrayList<>();
        list.add("Jeden");
        list.add("Dwa");
        list.add("Trzy");

        Random r = new Random();
        int i = r.nextInt(list.size());

        return list.get(i);
    }
}
