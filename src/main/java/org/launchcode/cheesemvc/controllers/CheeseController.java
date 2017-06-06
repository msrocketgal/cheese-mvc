package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by msroc on 5/17/2017.
 */
@Controller
@RequestMapping(value = "cheese")
public class CheeseController {

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model){
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute Cheese newCheese){
        CheeseData.add(newCheese);

        // Redirect to /cheese
        return "redirect:";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String displayDeleteCheeseForm(Model model){
        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "Remove Cheese");
        return "cheese/delete";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String processDeleteCheeseForm(@RequestParam int[] cheeseIDs){

        for(int cheeseID : cheeseIDs){
            CheeseData.delete(cheeseID);
        }
        // Redirect to /cheese
        return "redirect:";
    }

    //Create a method to display the form with this signature:
    @RequestMapping(value = "edit/{cheeseID}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int cheeseID){
        model.addAttribute("cheese", CheeseData.getByID(cheeseID));
        return "cheese/edit";
    }

    //Create a method to process the form with this signature:
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String processEditForm(int cheeseID, String cheeseName, String cheeseDescription){
        Cheese cheeseToEdit = CheeseData.getByID(cheeseID);
        cheeseToEdit.setCheeseName(cheeseName);
        cheeseToEdit.setCheeseDescription(cheeseDescription);
        return "redirect:";
    }
}
