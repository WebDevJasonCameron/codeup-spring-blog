package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Dice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("roll-dice")
public class RollController {

    @GetMapping
    public String showRollPage(){
        return "views-assignment/roll-dice";
    }

    @GetMapping("${n}")
    public String getRoll(@RequestParam(name = "")){

        return "views-assignment/roll-dice";
    }



}
