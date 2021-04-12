package edu.ucalgary.ensf409;

import java.sql.*;

public class Manufacturer {

    private int manuID;
    private String name;
    private String phone;
    private String province;

    // Constructor
    public Manufacturer() {
    }

    public Manufacturer(ResultSet results) {
        try {
            this.manuID = results.getInt("ManuID");
            this.name = results.getString("Name");
            this.phone = results.getString("Phone");
            this.province = results.getString("Province");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Getters
    public int getManuID() {
        return this.manuID;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getProvince() {
        return this.province;
    }

    // Setters
    public void setManuID(int manuID) {
        this.manuID = manuID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setProvince(String province) {
        this.province = province;
    }

}
