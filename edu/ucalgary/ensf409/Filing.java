package edu.ucalgary.ensf409;

import java.sql.*;

public class Filing extends Furniture {

    private String rails;
    private String drawers;
    private String cabinet;
    private Furniture furniture;

    // Constructor
    public Filing() {
    }

    public Filing(ResultSet results) {
        try {
            this.rails = results.getString("Rails");
            this.drawers = results.getString("Drawers");
            this.cabinet = results.getString("Cabinet");
            this.furniture = new Furniture(results);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Getters
    public String getRails() {
        return this.rails;
    }

    public String getDrawers() {
        return this.drawers;
    }

    public String getCabinet() {
        return this.cabinet;
    }

    public Furniture getFurniture() {
        return this.furniture;
    }

    // Setters
    public void setRails(String rails) {
        this.rails = rails;
    }

    public void setDrawers(String drawers) {
        this.drawers = drawers;
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }

    public void setFurniture(Furniture furniture) {
        this.furniture = furniture;
    }

}