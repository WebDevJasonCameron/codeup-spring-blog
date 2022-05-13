package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello World";
//    }
//
//    @GetMapping("/hello/{name}")
//    @ResponseBody
//    public String sayHello(@PathVariable String name){
//        return "Hello " + name +"!";
//    }
//
//
//    // Longer version ove above... why use?  Not known at this time
//    @RequestMapping(path = "/add100To/{number}", method = RequestMethod.GET)
//    @ResponseBody
//    public String addOneHundred(@PathVariable int number){
//        return  number + " + 100 = " + (number + 100);
//    }
//}
//
//@Controller
//@RequestMapping("/hello")               // <-- This added here
//public class HelloController {
//
//    @GetMapping("")
//    @ResponseBody
//    public String hello(){
//        return "Hello World";
//    }
//
//    @GetMapping("/{name}")
//    @ResponseBody
//    public String sayHello(@PathVariable String name){
//        return "Hello " + name +"!";
//    }
//
//    @GetMapping("/{name}")
//    @ResponseBody
//    public String sayHi(@PathVariable String name){
//        return "Hello " + name + "!";
//    }

//    @GetMapping("/{name")
//    @ResponseBody
//    public String randomGreeting(){
//        return "Hello " + names + "!";
//    }
//
//
//    @GetMapping("/{name1}/{name2}")
//    @ResponseBody
//    public String greetTwo(@PathVariable String name1, @PathVariable String name2){
//        return "Hello, " + name1 + " and " + name2 + "!";
//    }
//
//
//    @GetMapping("/{name1}/to/{name2}")
//    @ResponseBody
//    public String oneGreetsAnother(@PathVariable String name1, @PathVariable String name2) {
//        return name1 + " greets " + name2 + "!";
//
//
//    }
//
//
//
//    private final String[] names = {"Omar", "Mateo", "Liam", "Emma", "Reem", "Sofia", "James", "Agustin", "Antonella", "Youssef", "Abigail", "Zahra"};
//
}