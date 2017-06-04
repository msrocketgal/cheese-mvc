package org.launchcode.cheesemvc.models;

/**
 * Created by msroc on 5/21/2017.
 */
public class Cheese {

    private String cheeseName;
    private String cheeseDescription;

    public Cheese(String cheeseName, String cheeseDescription){
        this.cheeseName = cheeseName;
        this.cheeseDescription = cheeseDescription;
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

}
