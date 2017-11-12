package com.cosmo.arquitecturamvpbase.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by Lisandro Gómez on 11/12/17.
 */

@Root(name = "breakfast_menu")
public class BreakfastMenu {

    @ElementList(inline = true, entry = "food")
    private ArrayList<Food> foods;

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }
}
