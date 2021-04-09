package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.*;

public class Management {
    private Vector<Chair> chair = new Vector<Chair>();
    private Vector<Desk> desk = new Vector<Desk>();
    private Vector<Filing> filing = new Vector<Filing>();
    private Vector<Lamp> lamp = new Vector<Lamp>();

    private int priority;

    // Constructor
    public Management() {
    }

    public Management(ResultSet results, String category, String type) {
        try {
            while (results.next()) {
                if (results.getString("Type").equals(type)) {
                    if (category.toUpperCase().equals("CHAIR")) {
                        priority = 0;
                        setChair(results);
                    } else if (category.toUpperCase().equals("DESK")) {
                        priority = 1;
                        setDesk(results);
                    } else if (category.toUpperCase().equals("FILING")) {
                        priority = 2;
                        setFiling(results);
                    } else if (category.toUpperCase().equals("LAMP")) {
                        priority = 3;
                        setLamp(results);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Getters
    public Vector<Chair> getChair() {
        return this.chair;
    }

    public Vector<Desk> getDesk() {
        return this.desk;
    }

    public Vector<Filing> getFiling() {
        return this.filing;
    }

    public Vector<Lamp> getLamp() {
        return this.lamp;
    }

    public int getPriority() {
        return this.priority;
    }

    // Setters
    public void setChair(ResultSet results) {
        this.chair.add(new Chair(results));
    }

    public void setDesk(ResultSet results) {
        this.desk.add(new Desk(results));
    }

    public void setFiling(ResultSet results) {
        this.filing.add(new Filing(results));
    }

    public void setLamp(ResultSet results) {
        this.lamp.add(new Lamp(results));
    }

    // Print
    public void printChair() {
        for (int i = 0; i < chair.size(); i++) {
            System.out.println(chair.get(i).getFurniture().getID());
        }
    }

    public void printDesk() {
        for (int i = 0; i < desk.size(); i++) {
            System.out.println(desk.get(i).getFurniture().getID());
        }
    }

    public void printFiling() {
        for (int i = 0; i < filing.size(); i++) {
            System.out.println(filing.get(i).getRails());
        }
    }

    public void printLamp() {
        for (int i = 0; i < lamp.size(); i++) {
            System.out.println(lamp.get(i).getFurniture().getID());
        }
    }
}
