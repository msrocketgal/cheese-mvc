package org.launchcode.cheesemvc.models;

/**
 * Created by msroc on 6/7/2017.
 */
public enum CheeseType {

    HARD ("Hard"),
    SOFT ("Soft"),
    FAKE ("Fake");

    private final String name;

    CheeseType(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
