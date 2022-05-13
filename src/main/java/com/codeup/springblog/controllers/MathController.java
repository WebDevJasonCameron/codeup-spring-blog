package com.codeup.springblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {

    // Longer version ove above... why use?  Not known at this time
    @RequestMapping(path = "/add100To/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOneHundred(@PathVariable int number){
        return  number + " + 100 = " + (number + 100);
    }


    @GetMapping("add/{n1}/and/{n2}")
    @ResponseBody
    public String addNums(@PathVariable int n1, @PathVariable int n2){
        return n1 + " + " + n2 + " = " + (n1 + n2);
    }

    @GetMapping("subtract/{n1}/and/{n2}")
    @ResponseBody
    public String subNums(@PathVariable int n1, @PathVariable int n2){
        return n1 + " - " + n2 + " - " + (n1 - n2);
    }

    @GetMapping("multiply/{n1}/and/{n2}")
    @ResponseBody
    public String multNums(@PathVariable int n1, @PathVariable int n2){
        return n1 + " * " + n2 + " = " + (n1 * n2);
    }

    @GetMapping("divide/{n1}/and/{n2}")
    @ResponseBody
    public String divNums(@PathVariable int n1, @PathVariable int n2){
        return n1 + " / " + n2 + " = " + (n1 / n2);
    }

}
