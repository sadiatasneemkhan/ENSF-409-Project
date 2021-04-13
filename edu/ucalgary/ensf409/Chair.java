/**
 * @author Etienne Lagace <a
 * href="mailto:etienne.lagace@ucalgary.ca">etienne.lagace@ucalgary.ca</a>
 * @version 2.0
 * @since 0.1
 */

package edu.ucalgary.ensf409;

import java.sql.*;

/**
 * Chair is a simple class that represents the furniture item CHAIR from the
 * INVENTORY query. It contains a private String variables for each part and a
 * Funiture variable for all common columns of each furniture category
 */
public class Chair {

    private String legs;
    private String arms;
    private String seat;
    private String cushion;
    private Furniture furniture;

    // Constructor
    public Chair() {
    }

    /**
     * @summary Fills Chair class with results from INVENTORY query
     * 
     * @description Uses ResultSet variable from SQL library to fill Chair class
     *              with neccessary Strings for parts and sends the rest of the
     *              ResultSet variable to initialize a Funiture class item
     * 
     * @param results
     * 
     * @return
     */
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
    /**
     * @summary Returns legs variable
     * 
     * @description Returns legs private String variable from class Chair
     * 
     * @param
     * 
     * @return legs
     */
    public String getLegs() {
        return this.legs;
    }

    /**
     * @summary Returns arms variable
     * 
     * @description Returns arms private String variable from class Chair
     * 
     * @param
     * 
     * @return arms
     */
    public String getArms() {
        return this.arms;
    }

    /**
     * @summary Returns seat variable
     * 
     * @description Returns seat private String variable from class Chair
     * 
     * @param
     * 
     * @return seat
     */
    public String getSeat() {
        return this.seat;
    }

    /**
     * @summary Returns cushion variable
     * 
     * @description Returns cushion private String variable from class Chair
     * 
     * @param
     * 
     * @return cushion
     */
    public String getCushion() {
        return this.cushion;
    }

    /**
     * @summary Returns furniture variable
     * 
     * @description Returns furniture private Furniture variable from class Chair
     * 
     * @param
     * 
     * @return furniture
     */
    public Furniture getFurniture() {
        return this.furniture;
    }

    // Setters
    /**
     * @summary Sets legs variable
     * 
     * @description Sets legs private String variable from class Chair
     * 
     * @param legs
     * 
     * @return
     */
    public void setLegs(String legs) {
        this.legs = legs;
    }

    /**
     * @summary Sets arms variable
     * 
     * @description Sets arms private String variable from class Chair
     * 
     * @param arms
     * 
     * @return
     */
    public void setArms(String arms) {
        this.arms = arms;
    }

    /**
     * @summary Sets seat variable
     * 
     * @description Sets seat private String variable from class Chair
     * 
     * @param seat
     * 
     * @return
     */
    public void setSeat(String seat) {
        this.seat = seat;
    }

    /**
     * @summary Sets cushion variable
     * 
     * @description Sets cushion private String variable from class Chair
     * 
     * @param cushion
     * 
     * @return
     */
    public void setCushion(String cushion) {
        this.cushion = cushion;
    }

    /**
     * @summary Sets furniture variable
     * 
     * @description Sets furniture private Furniture variable from class Chair
     * 
     * @param furniture
     * 
     * @return
     */
    public void setFurniture(Furniture furniture) {
        this.furniture = furniture;
    }
}