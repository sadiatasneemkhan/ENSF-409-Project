package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.*;

public class Management {
    private Vector<Chair> chair = new Vector<Chair>();
    private Vector<Desk> desk = new Vector<Desk>();
    private Vector<Filing> filing = new Vector<Filing>();
    private Vector<Lamp> lamp = new Vector<Lamp>();
    private Vector<Vector<String>> parts = new Vector<Vector<String>>();

    private Vector<Integer> index = new Vector<Integer>();
    private Vector<Boolean> usable = new Vector<Boolean>();
    private int price = 10000;

    private int priority;

    // Constructor
    public Management() {
    }

    public Management(ResultSet results, String category, String type) {
        try {
            while (results.next()) {
                if (results.getString("Type").equals(type)) {
                    this.parts.add(new Vector<String>());

                    if (category.toUpperCase().equals("CHAIR")) {
                        priority = 0;
                        setChair(results);
                        parts.get(parts.size() - 1).add(results.getString("Legs"));
                        parts.get(parts.size() - 1).add(results.getString("Arms"));
                        parts.get(parts.size() - 1).add(results.getString("Seat"));
                        parts.get(parts.size() - 1).add(results.getString("Cushion"));
                    } else if (category.toUpperCase().equals("DESK")) {
                        priority = 1;
                        setDesk(results);
                        parts.get(parts.size() - 1).add(results.getString("Legs"));
                        parts.get(parts.size() - 1).add(results.getString("Top"));
                        parts.get(parts.size() - 1).add(results.getString("Drawer"));
                    } else if (category.toUpperCase().equals("FILING")) {
                        priority = 2;
                        setFiling(results);
                        parts.get(parts.size() - 1).add(results.getString("Rails"));
                        parts.get(parts.size() - 1).add(results.getString("Drawers"));
                        parts.get(parts.size() - 1).add(results.getString("Cabinet"));
                    } else if (category.toUpperCase().equals("LAMP")) {
                        priority = 3;
                        setLamp(results);
                        parts.get(parts.size() - 1).add(results.getString("Base"));
                        parts.get(parts.size() - 1).add(results.getString("Bulb"));
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

    public int getPrice() {
        return this.price;
    }

    public Vector<Integer> getIndex() {
        return this.index;
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
            System.out.println(filing.get(i).getFurniture().getID());
        }
    }

    public void printLamp() {
        for (int i = 0; i < lamp.size(); i++) {
            System.out.println(lamp.get(i).getFurniture().getID());
        }
    }

    public void printParts() {
        int l = parts.size();
        int n = parts.get(0).size();

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(parts.get(i).get(j) + "  ");
            }
            System.out.println();
        }
    }

    // Combination algorithm
    public void combination(int steps) {
        index.add(-1);
        index.add(-1);

        int l;

        switch (priority) {
        case 0:
            l = parts.get(0).size();
            for (int i = 0; i < l; i++) {
                usable.add(false);
            }

            for (int i = 1; i <= l; i++) {
                finalStep(chair.size(), l, i, 0, usable);

                if (index.size() > 2) {
                    this.price = Price(index.get(2));
                    index.set(0, index.get(2));
                    index.removeElementAt(1);
                    index.removeElementAt(1);
                }

                if (price != 10000) {
                    break;
                }
            }
            break;
        case 1:
            l = parts.get(0).size();
            for (int i = 0; i < l; i++) {
                usable.add(false);
            }

            for (int i = 1; i <= l; i++) {
                finalStep(desk.size(), l, i, 0, usable);

                if (index.size() > 2) {
                    this.price = Price(index.get(2));
                    index.set(0, index.get(2));
                    index.removeElementAt(1);
                    index.removeElementAt(1);
                }

                if (price != 10000) {
                    break;
                }
            }
            break;
        case 2:
            l = parts.get(0).size();
            for (int i = 0; i < l; i++) {
                usable.add(false);
            }

            for (int i = 1; i <= l; i++) {
                finalStep(filing.size(), l, i, 0, usable);

                if (index.size() > 2) {
                    this.price = Price(index.get(2));
                    index.set(0, index.get(2));
                    index.removeElementAt(1);
                    index.removeElementAt(1);
                }

                if (price != 10000) {
                    break;
                }
            }
            break;
        case 3:
            l = parts.get(0).size();
            for (int i = 0; i < l; i++) {
                usable.add(false);
            }

            for (int i = 1; i <= l; i++) {
                finalStep(lamp.size(), l, i, 0, usable);

                if (index.size() > 2) {
                    this.price = Price(index.get(2));
                    index.set(0, index.get(2));
                    index.removeElementAt(1);
                    index.removeElementAt(1);
                }

                if (price != 10000) {
                    break;
                }
            }
            break;
        }
    }

    public void finalStep(int length, int innerLength, int level, int position, Vector<Boolean> previous) {
        previous = resetVector(previous);

        while (position < length) {
            for (int i = 0; i < innerLength; i++) {
                if (parts.get(position).get(i).equals("Y")) {
                    usable.set(i, true);
                }
            }

            if (level != 1) {
                finalStep(length, innerLength, level - 1, position + 1, usable);
                if (index.get(0) == -1 && index.get(1) == -1 && index.size() > 2) {
                    price = Price(position) + Price(index.get(2));

                    index.set(0, position);
                    index.set(1, index.get(2));
                }

                for (int i = index.size() - 1; i > 1; i--) {
                    if (Price(position) + Price(index.get(i)) < price) {
                        price = Price(position) + Price(index.get(i));

                        index.set(0, position);
                        index.set(1, index.get(i));
                    }
                }

                while (index.size() != 2) {
                    index.removeElementAt(2);
                }
            }

            for (int i = 0; i < innerLength; i++) {
                if (usable.get(i)) {
                    if (i == innerLength - 1) {
                        index.add(position);
                        usable = resetVector(previous);
                    }
                } else {
                    usable = resetVector(previous);
                    break;
                }
            }

            position++;
        }
    }

    // Reset
    public Vector<Boolean> resetVector(Vector<Boolean> previous) {
        Vector<Boolean> temp = new Vector<Boolean>();
        int l = previous.size();

        for (int i = 0; i < l; i++) {
            if (previous.get(i)) {
                temp.add(true);
            } else {
                temp.add(false);
            }
        }

        return temp;
    }

    // Price
    public int Price(int position) {
        switch (priority) {
        case 0:
            return chair.get(position).getFurniture().getPrice();
        case 1:
            return desk.get(position).getFurniture().getPrice();
        case 2:
            return filing.get(position).getFurniture().getPrice();
        case 3:
            return lamp.get(position).getFurniture().getPrice();
        }
        return -1;
    }
}
