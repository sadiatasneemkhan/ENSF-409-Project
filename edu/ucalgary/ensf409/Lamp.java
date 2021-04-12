package edu.ucalgary.ensf409;

import java.sql.*;

public class Lamp extends Furniture {

    private String base;
    private String bulb;
    private Furniture furniture;

    // Constructor
    public Lamp() {
    }
    
    public Lamp(ResultSet results) {
        try {
            this.base = results.getString("Base");
            this.bulb = results.getString("Bulb");
            this.furniture = new Furniture(results);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Getters
    public String getBase() {
        return this.base;
    }

    public String getBulb() {
        return this.bulb;
    }

    public Furniture getFurniture() {
        return this.furniture;
    }

    // Setters
    public void setBase(String base) {
        this.base = base;
    }

    public void setBulb(String bulb) {
        this.bulb = bulb;
    }

    public void setFurniture(Furniture furniture) {
        this.furniture = furniture;
    }

}
