package edu.ucalgary.ensf409;

import java.sql.*;

public class Chair extends Furniture {

    private String legs;
    private String arms;
    private String seat;
    private String cushion;
    private Furniture furniture;

    // Constructor
    public Chair() {
    }

    public Chair(ResultSet results) {
        try {
            this.legs = results.getString("Legs");
            this.arms = results.getString("Arms");
            this.seat = results.getString("Seat");
            this.cushion = results.getString("Cushion");
            this.furniture = new Furniture(results);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Getters
    public String getLegs() {
        return this.legs;
    }

    public String getArms() {
        return this.arms;
    }

    public String getSeat() {
        return this.seat;
    }

    public String getCushion() {
        return this.cushion;
    }

    public Furniture getFurniture() {
        return this.furniture;
    }

    // Setters
    public void setLegs(String legs) {
        this.legs = legs;
    }

    public void setArms(String arms) {
        this.arms = arms;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public void setCushion(String cushion) {
        this.cushion = cushion;
    }

    public void setFurniture(Furniture furniture) {
        this.furniture = furniture;
    }
}
