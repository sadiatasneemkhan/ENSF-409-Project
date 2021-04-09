package edu.ucalgary.ensf409;

import java.sql.*;

public class Desk extends Furniture {

    private String legs;
    private String top;
    private String drawer;
    private Furniture furniture;

    // Constructor
    public Desk() {
    }

    public Desk(ResultSet results) {
        try {
            this.legs = results.getString("Legs");
            this.top = results.getString("Top");
            this.drawer = results.getString("Drawer");
            this.furniture = new Furniture(results);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Getters
    public String getLegs() {
        return this.legs;
    }

    public String getTop() {
        return this.top;
    }

    public String getDrawer() {
        return this.drawer;
    }

    public Furniture getFurniture() {
        return this.furniture;
    }

    // Setters
    public void setLegs(String legs) {
        this.legs = legs;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public void setDrawer(String drawer) {
        this.drawer = drawer;
    }

    public void setFurniture(Furniture furniture) {
        this.furniture = furniture;
    }

}