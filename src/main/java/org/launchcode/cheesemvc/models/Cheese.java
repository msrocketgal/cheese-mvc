package org.launchcode.cheesemvc.models;

/**
 * Created by msroc on 5/21/2017.
 */
public class Cheese {

    private String cheeseName;
    private String cheeseDescription;
    private int cheeseID;
    private static int nextID = 1;

    public Cheese(String cheeseName, String cheeseDescription){
        this();
        this.cheeseName = cheeseName;
        this.cheeseDescription = cheeseDescription;
    }

    public Cheese(){
        this.cheeseID = nextID;
        nextID++;
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
}
