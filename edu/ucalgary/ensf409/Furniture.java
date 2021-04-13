/**
 * @author Etienne Lagace <a
 * href="mailto:etienne.lagace@ucalgary.ca">etienne.lagace@ucalgary.ca</a>
 * @version 1.2
 * @since 1.0
 */

package edu.ucalgary.ensf409;

import java.sql.*;

/**
 * Furniture is a simple class that holds a variable for every common column
 * found within each furniture item of the INVENTORY query.
 */
public class Furniture {

    // Common fields amongst the furniture
    private String id;
    private String type;
    private int price;
    private int manuID;

    // Constructor
    public Furniture() {
    }

    /**
     * @summary Fills Furniture class with results from INVENTORY query
     * 
     * @description Uses ResultSet variable from SQL library to fill Furniture class
     *              with neccessary Strings and Integers for the common columns of
     *              every furniture item
     * 
     * @param results
     * 
     * @return
     */
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
    /**
     * @summary Returns id variable
     * 
     * @description Returns id private String variable from class Furniture
     * 
     * @param
     * 
     * @return id
     */
    public String getID() {
        return this.id;
    }

    /**
     * @summary Returns type variable
     * 
     * @description Returns type private String variable from class Furniture
     * 
     * @param
     * 
     * @return type
     */
    public String getType() {
        return this.type;
    }

    /**
     * @summary Returns price variable
     * 
     * @description Returns price private Int variable from class Furniture
     * 
     * @param
     * 
     * @return price
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * @summary Returns manuID variable
     * 
     * @description Returns manuID private Int variable from class Furniture
     * 
     * @param
     * 
     * @return manuID
     */
    public int getManuID() {
        return this.manuID;
    }

    // Setters
    /**
     * @summary Sets id variable
     * 
     * @description Sets id private String variable from class Furniture
     * 
     * @param id
     * 
     * @return
     */
    public void setID(String id) {
        this.id = id;
    }

    /**
     * @summary Sets type variable
     * 
     * @description Sets type private String variable from class Furniture
     * 
     * @param type
     * 
     * @return
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @summary Sets price variable
     * 
     * @description Sets price private Int variable from class Furniture
     * 
     * @param price
     * 
     * @return
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @summary Sets manuID variable
     * 
     * @description Sets manuID private Int variable from class Furniture
     * 
     * @param manuID
     * 
     * @return
     */
    public void setManuID(int manuID) {
        this.manuID = manuID;
    }

}