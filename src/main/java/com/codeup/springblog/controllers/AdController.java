package com.codeup.springblog.controllers;

import com.codeup.springblog.repositories.AdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ads")
public class AdController {

    // ATT
    private final AdRepository adDao;

    // CON        --> Dependency Injection
    public AdController(AdRepository adDao) {
        this.adDao = adDao;
    }

    // METHS
    @GetMapping
    public String allAds(Model model){
        model.addAttribute("ads", adDao.findAll());
        return "ads/index";
    }

    @PostMapping("/search")
    public String SearchResults(@RequestParam(name="title") String title){
        adDao.searchByTitleLike(title);
        return "ads/index";
    }

//

}  //<--END
