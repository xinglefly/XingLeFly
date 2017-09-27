package com.example;



import java.util.ArrayList;
import java.util.List;

public class MyClass {

    public static void main(String srgs[]) throws Exception{

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        String[] s = (String[]) list.toArray();
        System.out.println(("list: %s"+list.toString()));
        System.out.println(("list: %s"+s.length));


    }
}
