package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {

    @GetMapping
    @ResponseBody
    public String postWork(){
        return "posts index page";
    }

    @GetMapping("{id}")
    @ResponseBody
    public String postById(@PathVariable long id){
        return "here is the post " + id ;
    }

    @GetMapping("/create")
    @ResponseBody
    public String createPost(){
        return "you just created a post";
    }

    @PostMapping("/create")
    @ResponseBody
    public String submitPost(){
        return "you just created a post";
    }



}
