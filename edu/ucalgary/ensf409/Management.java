/** 
 * @author Etienne Lagace <a>
 * href="mailto:etienne.lagace@ucalgary.ca">etienne.lagace@ucalgary.ca</a>
 * @author Haniya Ahmed <a>
 * href="mailto:haniya.ahmed@ucalgary.ca">haniya.ahmed@ucalgary.ca</a>
 * @author Sadia Khan <a>
 * href="mailto:sadia.khan1@ucalgary.ca">sadia.khan1@ucalgary.ca</a>
 * @author Andres Caicedo <a>
 * href="mailto:acaicedo@ucalgary.ca">acaicedo@ucalgary.ca.ca</a>
 * @version 1.1
 * @since 1.0
 */
package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.*;

/**
 * Management is a simple class that uses ResultSet objects passed from the Inventory class to initialized vectors of the furniture category requested. The class then proceeds
 * to employ an algorithm to determine all possible combination to fulfill the order request, along with determining the cheapest output
 */

public class Management {
    private Vector<Chair> chair = new Vector<Chair>();
    private Vector<Desk> desk = new Vector<Desk>();
    private Vector<Filing> filing = new Vector<Filing>();
    private Vector<Lamp> lamp = new Vector<Lamp>();
    private Vector<Manufacturer> manufacturer = new Vector<Manufacturer>();
    private Vector<Vector<String>> parts = new Vector<Vector<String>>();

    private Vector<Vector<Integer>> index = new Vector<Vector<Integer>>();
    private Vector<Integer> remember = new Vector<Integer>();
    private Vector<Boolean> usable = new Vector<Boolean>();
    private Vector<Integer> price = new Vector<Integer>();
    private Vector<String> ID = new Vector<String>();

    private StringBuilder names = new StringBuilder();
    private Boolean overflow = false;
    private int priority;

    // Constructor
    public Management() {
    }
	
    /**
     * @summary Acquires all component columns of the requested furniture category
     * 
     * @description Uses results passed from the ResultSet object in the Inventory class
	 * and each String vector row recieves an inventory item that match the requested
	 * furniture type. Further, int priority is used in order to reduce the repetition of code
	 * and easily determine the category of furniture requested
     * 
     * @param results - results of inventory items within the requested furniture category
	 * @param category - name of the furniture category
	 * @param type - name of the type of furniture requested
     * 
     * @return
     */	
    public Management(ResultSet results, String category, String type) {
        try {
            while (results.next()) {
                if (results.getString("Type").equalsIgnoreCase(type)) {
                    this.parts.add(new Vector<String>());

                    if (category.equalsIgnoreCase("CHAIR")) {
                        priority = 0;
                        setChair(results);
                        parts.get(parts.size() - 1).add(results.getString("Legs"));
                        parts.get(parts.size() - 1).add(results.getString("Arms"));
                        parts.get(parts.size() - 1).add(results.getString("Seat"));
                        parts.get(parts.size() - 1).add(results.getString("Cushion"));
                    } else if (category.equalsIgnoreCase("DESK")) {
                        priority = 1;
                        setDesk(results);
                        parts.get(parts.size() - 1).add(results.getString("Legs"));
                        parts.get(parts.size() - 1).add(results.getString("Top"));
                        parts.get(parts.size() - 1).add(results.getString("Drawer"));
                    } else if (category.equalsIgnoreCase("FILING")) {
                        priority = 2;
                        setFiling(results);
                        parts.get(parts.size() - 1).add(results.getString("Rails"));
                        parts.get(parts.size() - 1).add(results.getString("Drawers"));
                        parts.get(parts.size() - 1).add(results.getString("Cabinet"));
                    } else if (category.equalsIgnoreCase("LAMP")) {
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
	    /**
     * @summary Returns the Chair inventory 
     * 
     * @description Returns a vector of type Chair which holds all inventory matching the requested furniture type
     * 
     * @param 
     * 
     * @return Chair vector containing all chair inventory that matches the requested furniture type
     */	
    public Vector<Chair> getChair() {
        return this.chair;
    }

	    /**
     * @summary Returns the Desk inventory 
     * 
     * @description Returns a vector of type Desk which holds all inventory matching the requested furniture type
     * 
     * @param 
     * 
     * @return Desk vector containing all desk inventory that matches the requested furniture type
     */	
    public Vector<Desk> getDesk() {
        return this.desk;
    }

	    /**
     * @summary Returns the Filing inventory 
     * 
     * @description Returns a vector of type Filing which holds all inventory matching the requested furniture type
     * 
     * @param 
     * 
     * @return Filing vector containing all filing inventory that matches the requested furniture type
     */	
    public Vector<Filing> getFiling() {
        return this.filing;
    }
	
    /**
     * @summary Returns the Lamp inventory 
     * 
     * @description Returns a vector of type Lamp which holds all inventory matching the requested furniture type
     * 
     * @param 
     * 
     * @return Lamp vector containing lamp chair inventory that matches the requested furniture type
     */	

    public Vector<Lamp> getLamp() {
        return this.lamp;
    }

	 /**
     * @summary Returns the Manufacturers list
     * 
     * @description Returns a list of manufacturers
     * 
     * @param 
     * 
     * @return Manufacturer vector containing a list of manufacturer names
     */	
    public Vector<Manufacturer> getManufacturer() {
        return this.manufacturer;
    }

	 /**
     * @summary Returns int prioriy - an indicator of what furniture category was requested
     * 
     * @description Returns an int which represents what furniture category was requested
     * 
     * @param 
     * 
     * @return Int - furniture category
     */	
    public int getPriority() {
        return this.priority;
    }
	

	 /**
     * @summary Returns the Manufacturers list
     * 
     * @description Returns a list of manufacturers
     * 
     * @param 
     * 
     * @return Manufacturer vector containing a list of manufacturer names
     */	
    public Vector<Integer> getPrice() {
        return this.price;
    }


    public Vector<Vector<Integer>> getIndex() {           //////////////////////////////////comment here
        return this.index;
    }

	 /**
     * @summary Returns the ID's of inventory item(s) in String format
     * 
     * @description Returns a String that contains all the ID's of ordered inventory items
     * 
     * @param 
     * 
     * @return ID's of inventory items.
     */	
    public String getIDString() {
        StringBuilder temp = new StringBuilder();

        int l = ID.size();
        for (int i = 0; i < l; i++) {
            temp.append(ID.get(i));
            if (i < l - 1) {
                temp.append("\n");
            }
        }

        return temp.toString();
    }

	 /**
     * @summary Returns a vector of inventory item IDs
     * 
     * @description Returns a String vector containing the ID's of inventory items
     * 
     * @param 
     * 
     * @return String vector containing inventory item IDs
     */	
    public Vector<String> getIDVector() {
        return this.ID;
    }

	 /**
     * @summary Returns the names of manufaturers in String format
     * 
     * @description Returns a list of manufacturers as a String
     * 
     * @param 
     * 
     * @return manufacturer names
     */	
    public String getManuNames() {
        return this.names.toString();
    }
	
	 /**
     * @summary Returns a boolean value representative of overflow
     * 
     * @description Returns a boolean value which is true if overflow is present, and false if there is no overflow
     * 
     * @param 
     * 
     * @return true if there is overflow, false if there is none
     */	

    public Boolean getOverflow() {
        return this.overflow;
    }

    // Setters
	
	 /**
     * @summary Adds a chair to the Chair vector
     * 
     * @description Adds a new chair from the ResultSet object to the Chair vector
     * 
     * @param ResultSet object from the desk inventory in the SQL database
     * 
     * @return 
     */	
    public void setChair(ResultSet results) {
        this.chair.add(new Chair(results));
    }

	 /**
     * @summary Adds a desk to the Desk vector
     * 
     * @description Adds a new desk from the ResultSet object to the Desk vector
     * 
     * @param ResultSet object from the desk inventory in the SQL database
     * 
     * @return 
     */	

    public void setDesk(ResultSet results) {
        this.desk.add(new Desk(results));
    }
	
	/**
     * @summary Adds a fliing to the Filing vector
     * 
     * @description Adds a new filing from the ResultSet object to the Filing vector
     * 
     * @param ResultSet object from the filing inventory in the SQL database
     * 
     * @return 
     */	

    public void setFiling(ResultSet results) {
        this.filing.add(new Filing(results));
    }

	/**
     * @summary Adds a lamp to the Lamp vector
     * 
     * @description Adds a new lamp from the ResultSet object to the Lamp vector
     * 
     * @param ResultSet object from the lamp inventory in the SQL database
     * 
     * @return 
     */	
    public void setLamp(ResultSet results) {
        this.lamp.add(new Lamp(results));
    }

	/**
     * @summary Adds a manufacturer to the Manufacturer vector
     * 
     * @description Adds a new manufacturer from the ResultSet object to the Manufacturer vector
     * 
     * @param ResultSet object from the manufacturer table in the SQL database
     * 
     * @return 
     */	
    public void setManufacturer(ResultSet results) {
        this.manufacturer.add(new Manufacturer(results));
    }

    // Print
	/**
     * @summary Prints the ID's of all the items in the Chair vector
     * 
     * @description Prints the ID's of all the items stored in the Chair vector
     * 
     * @param 
     * 
     * @return 
     */	
    public void printChair() {
        for (int i = 0; i < chair.size(); i++) {
            System.out.println(chair.get(i).getFurniture().getID());
        }
    }

	/**
     * @summary Prints the ID's of all the items in the Desk vector
     * 
     * @description Prints the ID's of all the items stored in the Desk vector
     * 
     * @param 
     * 
     * @return 
     */	
    public void printDesk() {
        for (int i = 0; i < desk.size(); i++) {
            System.out.println(desk.get(i).getFurniture().getID());
        }
    }

	/**
     * @summary Prints the ID's of all the items in the Filing vector
     * 
     * @description Prints the ID's of all the items stored in the Filing vector
     * 
     * @param 
     * 
     * @return 
     */	
    public void printFiling() {
        for (int i = 0; i < filing.size(); i++) {
            System.out.println(filing.get(i).getFurniture().getID());
        }
    }

	/**
     * @summary Prints the ID's of all the items in the Lamp vector
     * 
     * @description Prints the ID's of all the items stored in the Lamp vector
     * 
     * @param 
     * 
     * @return 
     */	
    public void printLamp() {
        for (int i = 0; i < lamp.size(); i++) {
            System.out.println(lamp.get(i).getFurniture().getID());
        }
    }
	
	/**
     * @summary Prints the Y/N status of each inventory item component 
     * 
     * @description Prints out the Y/N values of each component of a furniture category
     * 
     * @param 
     * 
     * @return 
     */	

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
	/**
     * @summary Executes a combination algorithm to determine possible combinations that could fulfill the order request
     * 
     * @description Prints the ID's of all the items stored in the Chair vector
     * 
     * @param 
     * 
     * @return 
     */	
    public void combination(int steps) {
        manufacturerNames();

        for (int k = 0; k < steps; k++) {
            index.add(new Vector<Integer>());
            price.add(10000);

            int l;
            l = parts.get(0).size();
            for (int i = 0; i < l; i++) {
                if (k == 0) {
                    usable.add(false);
                } else {
                    usable.set(i, false);
                }
                index.get(0).add(-1);
            }

            switch (priority) {
            case 0:
                for (int i = 1; i <= l; i++) {
                    recursive(chair.size(), l, i, 0, usable);
                    findLowestPrice(k);

                    if (price.get(k) != 10000) {
                        break;
                    }
                }

                for (int i = 0; i < l; i++) {
                    if (index.get(0).get(i) != -1) {
                        ID.add(chair.get(index.get(0).get(i)).getFurniture().getID());
                        chair.removeElementAt(index.get(0).get(i));
                        parts.removeElementAt(index.get(0).get(i));
                    }
                }

                break;
            case 1:
                for (int i = 1; i <= l; i++) {
                    recursive(desk.size(), l, i, 0, usable);
                    findLowestPrice(k);

                    if (price.get(k) != 10000) {
                        break;
                    }
                }

                for (int i = 0; i < l; i++) {
                    if (index.get(0).get(i) != -1) {
                        ID.add(desk.get(index.get(0).get(i)).getFurniture().getID());
                        desk.removeElementAt(index.get(0).get(i));
                        parts.removeElementAt(index.get(0).get(i));
                    }
                }
                break;
            case 2:
                for (int i = 1; i <= l; i++) {
                    recursive(filing.size(), l, i, 0, usable);
                    findLowestPrice(k);

                    if (price.get(k) != 10000) {
                        break;
                    }
                }

                for (int i = 0; i < l; i++) {
                    if (index.get(0).get(i) != -1) {
                        ID.add(filing.get(index.get(0).get(i)).getFurniture().getID());
                        filing.removeElementAt(index.get(0).get(i));
                        parts.removeElementAt(index.get(0).get(i));
                    }
                }
                break;
            case 3:
                for (int i = 1; i <= l; i++) {
                    recursive(lamp.size(), l, i, 0, usable);
                    findLowestPrice(k);

                    if (price.get(k) != 10000) {
                        break;
                    }
                }

                for (int i = 0; i < l; i++) {
                    if (index.get(0).get(i) != -1) {
                        ID.add(lamp.get(index.get(0).get(i)).getFurniture().getID());
                        lamp.removeElementAt(index.get(0).get(i));
                        parts.removeElementAt(index.get(0).get(i));
                    }
                }
                break;
            }

            if (index.get(0).get(0) == -1 || (parts.isEmpty() && k != steps - 1)) {
                overflow = true;
                break;
            }

            index.removeAllElements();
        }
    }

    public void recursive(int length, int innerLength, int level, int position, Vector<Boolean> previous) {
        previous = resetVector(previous);

        while (position < length) {
            for (int i = 0; i < innerLength; i++) {
                if (parts.get(position).get(i).equals("Y")) {
                    usable.set(i, true);
                }
            }

            if (level != 1) {
                remember.add(position);
                recursive(length, innerLength, level - 1, position + 1, usable);
                remember.removeElement(position);
            }

            for (int i = 0; i < innerLength; i++) {
                if (usable.get(i)) {
                    if (i == innerLength - 1) {
                        index.add(new Vector<Integer>());
                        index.get(index.size() - 1).add(position);

                        for (int j = remember.size() - 1; j >= 0; j--) {
                            index.get(index.size() - 1).add(remember.get(j));
                        }

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

    public void findLowestPrice(int step) {
        int l = index.size();
        int n = 0;
        int p = 0;

        for (int i = 1; i < l; i++) {
            n = index.get(i).size();

            for (int j = 0; j < n; j++) {
                p += obtainPrice(index.get(i).get(j));
            }

            if (p < price.get(step)) {
                price.set(step, p);

                for (int j = 0; j < n; j++) {
                    index.get(0).set(j, index.get(i).get(j));
                }
            }

            p = 0;
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
    public int obtainPrice(int position) {
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

    // Suggested Manufacturer
    public void manufacturerNames() {
        int l = parts.size();
        for (int i = 0; i < l; i++) {
            switch (priority) {
            case 0:
                names.append(findManufacturer(chair.get(i).getFurniture().getManuID()));
                break;
            case 1:
                names.append(findManufacturer(desk.get(i).getFurniture().getManuID()));
                break;
            case 2:
                names.append(findManufacturer(filing.get(i).getFurniture().getManuID()));
                break;
            case 3:
                names.append(findManufacturer(lamp.get(i).getFurniture().getManuID()));
                break;
            }
        }
    }

    public String findManufacturer(int manuID) {
        int l = manufacturer.size();
        for (int i = 0; i < l; i++) {
            if (manufacturer.get(i).getManuID() == manuID) {
                if (names.length() > 0) {
                    names.append("\n");
                }
                String temp = manufacturer.get(i).getName();
                manufacturer.removeElementAt(i);
                return temp;
            }
        }

        return "";
    }

}
