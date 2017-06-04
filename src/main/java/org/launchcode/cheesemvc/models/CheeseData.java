package org.launchcode.cheesemvc.models;

import java.util.ArrayList;

/**
 * Created by msroc on 6/4/2017.
 */
public class CheeseData {

    static ArrayList<Cheese> cheeses = new ArrayList<Cheese>();

    // getAll
    public static ArrayList<Cheese> getAll(){
        return cheeses;
    }

    // add
    public static void add(Cheese newCheese){
        cheeses.add(newCheese);
    }

    // delete
    public static void delete(int id){
        Cheese cheeseToDelete = getByID(id);
        cheeses.remove(cheeseToDelete);
    }

    // getByID
    public static Cheese getByID(int id){
        Cheese theCheese = null;

        for(Cheese candidateCheese : cheeses){
            if(candidateCheese.getCheeseID() == id){
                theCheese = candidateCheese;
            }
        }

        return theCheese;
    }
}
