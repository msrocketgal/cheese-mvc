package org.launchcode.cheesemvc.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by msroc on 5/21/2017.
 */
public class Cheese {

    @NotNull
    @Size(min=3, max=15)
    private String cheeseName;

    @NotNull
    @Size(min=1, message = "Description must not be empty")
    private String cheeseDescription;

    private CheeseType type;
    private int cheeseID;
    private static int nextID = 1;

    public Cheese(String cheeseName, String cheeseDescription, CheeseType type){
        this();
        this.cheeseName = cheeseName;
        this.cheeseDescription = cheeseDescription;
        this.type = type;
    }

    public Cheese(){
        this.cheeseID = nextID;
        nextID = nextID + 1;
    }

    public String getCheeseName(){
        return this.cheeseName;
    }

    public void setCheeseName(String cheeseName) {
        this.cheeseName = cheeseName;
    }

    public String getCheeseDescription() {
        return this.cheeseDescription;
    }

    public void setCheeseDescription(String cheeseDescription) {
        this.cheeseDescription = cheeseDescription;
    }

    public int getCheeseID() {
        return cheeseID;
    }

    public void setCheeseID(int cheeseID) {
        this.cheeseID = cheeseID;
    }

    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType type) {
        this.type = type;
    }
}
