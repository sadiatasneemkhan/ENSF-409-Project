package edu.ucalgary.ensf409;

import java.sql.*;

public class Furniture {

    // Common fields amongst the furniture
    private String id;
    private String type;
    private int price;
    private int manuID;

    // Constructor
    public Furniture() {
    }

    public Furniture(ResultSet results) {
        try {
            this.id = results.getString("ID");
            this.type = results.getString("Type");
            this.price = results.getInt("Price");
            this.manuID = results.getInt("ManuID");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Getters
    public String getID() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    public int getPrice() {
        return this.price;
    }

    public int getManuID() {
        return this.manuID;
    }

    // Setters
    public void setID(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setManuID(int manuID) {
        this.manuID = manuID;
    }

}