package com.example.bladebuilder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
@RequestMapping("/order")
public class OrderController{


    @PostMapping()
    @ResponseBody
    public String add(@RequestBody String text){

        String[] split = text.split("\\\\n");

        for (String s : split) {
            String[] order = s.split("\\\\t");
            System.out.println(Arrays.toString(order));
            System.out.println("###########");
        }

        return "ok";
    }



}
