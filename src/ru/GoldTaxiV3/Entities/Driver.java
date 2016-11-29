package ru.GoldTaxiV3.Entities;

/**
 * Created by Scala on 13.11.2016.
 */
public class Driver {
    private String name;
    private String telephone;

    public Driver (String name, String telephone){
        this.name = name;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
