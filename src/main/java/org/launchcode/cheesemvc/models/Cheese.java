package org.launchcode.cheesemvc.models;

/**
 * Created by msroc on 5/21/2017.
 */
public class Cheese {

    private String cheeseName;
    private String cheeseDescription;

    public Cheese(String aCheeseName, String aCheeseDescription){
        setCheeseName(aCheeseName);
        setCheeseDescription(aCheeseDescription);
    }

    public String getCheeseName() {
        return cheeseName;
    }

    public void setCheeseName(String aCheeseName) {
        cheeseName = aCheeseName;
    }

    public String getCheeseDescription() {
        return cheeseDescription;
    }

    public void setCheeseDescription(String aCheeseDescription) {
        cheeseDescription = aCheeseDescription;
    }

}
