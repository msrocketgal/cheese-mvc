package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseType;
import org.launchcode.cheesemvc.models.data.CheeseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by msroc on 5/17/2017.
 */
@Controller
@RequestMapping(value = "cheese")
public class CheeseController {

    @Autowired
    private CheeseDao cheeseDao;

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("cheeses", cheeseDao.findAll());
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model){
        model.addAttribute("title", "Add Cheese");
        model.addAttribute(new Cheese());
        model.addAttribute("cheeseTypes", CheeseType.values());
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese newCheese, Errors errors, Model model){

        if(errors.hasErrors()){
            model.addAttribute("title", "Add Cheese");
            return "cheese/add";
        }
        cheeseDao.save(newCheese);
        return "redirect:";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String displayDeleteCheeseForm(Model model){
        model.addAttribute("cheeses", cheeseDao.findAll());
        model.addAttribute("title", "Remove Cheese");
        return "cheese/delete";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String processDeleteCheeseForm(@RequestParam int[] cheeseIDs){

        for(int cheeseID : cheeseIDs){
            cheeseDao.delete(cheeseID);
        }
        // Redirect to /cheese
        return "redirect:";
    }

    //Create a method to display the form with this signature:
    @RequestMapping(value = "edit/{cheeseID}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int cheeseID){
        Cheese cheese = cheeseDao.findOne(cheeseID);
        model.addAttribute("cheese", cheese);
        model.addAttribute("cheeseTypes", CheeseType.values());
        model.addAttribute("title", "Edit Cheese " + cheese.getCheeseName());
        return "cheese/edit";
    }

    //Create a method to process the form with this signature:
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String processEditForm(@ModelAttribute @Valid Cheese newCheese, Errors errors, Model model){

        if(errors.hasErrors()){
            model.addAttribute("title", "Edit Cheese " + newCheese.getCheeseName());
            model.addAttribute("cheese", newCheese);
            model.addAttribute("cheeseTypes", CheeseType.values());
            return "cheese/edit";
        }

        Cheese cheese = cheeseDao.findOne(newCheese.getId());
        cheese.setCheeseName(newCheese.getCheeseName());
        cheese.setCheeseDescription(newCheese.getCheeseDescription());
        cheese.setType(newCheese.getType());
        cheese.setRating(newCheese.getRating());
        return "redirect:";
    }
}
