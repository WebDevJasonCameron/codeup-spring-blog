package com.codeup.springblog.controllers;

import com.codeup.springblog.models.ChewToy;
import com.codeup.springblog.models.Pet;
import com.codeup.springblog.models.PetDetails;
import com.codeup.springblog.repositories.PetRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PetController {

    // ATT
    private final PetRepository petsDao;

    // CON
    public PetController(PetRepository petsDao) {
        this.petsDao = petsDao;
    }

    // METH
    @GetMapping("/pets")
    // @ResponseBody                                           // <-- exports JSON
    public List<Pet> returnPets() {
        return petsDao.findAll();
    }

    @GetMapping("/pets/{id}")
    public String returnPetsUpdateView(@PathVariable long id, Model model){
        Pet pet = petsDao.getById(id);
        model.addAttribute("pet", pet);
        return "pets/test";
    }

    @PostMapping("/pets/update/{id}")
    public String updatePersonality(@PathVariable long id, @RequestParam String personality){

        // get the correct pet obj to update
        Pet pet = petsDao.getById(id);

        // get the current pet details
        PetDetails pd = pet.getPetDetails();

        // update the pet details with the current details
        pd.setPersonalityDescription(personality);
        pet.setPetDetails(pd);

        // update the database record
        petsDao.save(pet);

        // STAND
        return "redirect:/pets";
    }


    // TESTING ONE TO MANY RELATIONSHIPS...
    @PostMapping("/pets/{id}/addtoy")
    public String addToy(
            @PathVariable long id,
            @RequestParam String name,
            @RequestParam String brand,
            @RequestParam(defaultValue = "false") boolean isDestroyed){

        Pet pet = petsDao.getById(id);
        ChewToy toy = new ChewToy(name, brand, isDestroyed, pet);

        List<ChewToy> chewToys = pet.getChewToys();                     //<--Allows the Many toys!
        chewToys.add(toy);

        pet.setChewToys(chewToys);                                      //<--Places updated list in Pet
        petsDao.save(pet);                                              //<--Now save the pet

        // STAN
        return "redirect:/pets";
    }



}  //<--END
