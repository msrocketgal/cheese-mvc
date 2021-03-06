package org.launchcode.cheesemvc.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by msroc on 5/21/2017.
 */
@Entity
public class Cheese {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String cheeseName;

    @NotNull
    @Size(min=1, message = "Description must not be empty")
    private String cheeseDescription;

    @NotNull
    @Min(1)
    @Max(5)
    private int rating;

    private CheeseType type;

    public Cheese(String cheeseName, String cheeseDescription, CheeseType type, int rating){
        this.cheeseName = cheeseName;
        this.cheeseDescription = cheeseDescription;
        this.type = type;
        this.rating = rating;
    }

    public Cheese(){

    }

    public int getId() {
        return id;
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

    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType type) {
        this.type = type;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
