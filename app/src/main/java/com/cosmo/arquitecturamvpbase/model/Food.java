package com.cosmo.arquitecturamvpbase.model;

import org.simpleframework.xml.Element;

/**
 * Created by Lisandro Gómez on 11/12/17.
 */

@Element(name = "food")
public class Food {

    @Element(name="name")
    private String name;

    @Element(name="price")
    private String price;

    @Element(name="description")
    private String description;

    @Element(name="calories")
    private long calories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCalories() {
        return calories;
    }

    public void setCalories(long calories) {
        this.calories = calories;
    }
}
