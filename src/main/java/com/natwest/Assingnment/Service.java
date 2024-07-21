package com.natwest.Assingnment;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    Repository repo;
    String configFile  = "C:/Users/disco/Desktop/Projects/Assingnment/Assingnment/src/main/resources/Transformation.properties";
    Properties properties = new Properties();

    public  Service() throws IOException {
        properties.load(new FileReader(configFile));
    }

    public void transform()
    {
        for(String i  :  properties.stringPropertyNames())
        {

            String temp  [] = properties.get(i).toString().split("[,()]");
            ArrayList<String> arr =  new ArrayList<>(Arrays.asList(temp));
            System.out.println(arr);
            Stack<String> stack = new Stack<>();
            for(int j =0 ;j< temp.length ;j++){
                stack.add(temp[j]);
            }

            System.out.println(stack);

        }
    }



}
