/**
 * @author Etienne Lagace <a
 * href="mailto:etienne.lagace@ucalgary.ca">etienne.lagace@ucalgary.ca</a>
 * @version 1.2
 * @since 1.0
 */

package edu.ucalgary.ensf409;

import java.sql.*;

/**
 * Desk is a simple class that represents the furniture item DESK from the
 * INVENTORY query. It contains a private String variables for each part and a
 * Funiture variable for all common columns of each furniture category
 */
public class Desk extends Furniture {

    private String legs;
    private String top;
    private String drawer;
    private Furniture furniture;

    // Constructor
    public Desk() {
    }

    /**
     * @summary Fills Desk class with results from INVENTORY query
     * 
     * @description Uses ResultSet variable from SQL library to fill Desk class with
     *              neccessary Strings for parts and sends the rest of the ResultSet
     *              variable to initialize a Funiture class item
     * 
     * @param results
     * 
     * @return
     */
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
    /**
     * @summary Returns legs variable
     * 
     * @description Returns legs private String variable from class Desk
     * 
     * @param
     * 
     * @return legs
     */
    public String getLegs() {
        return this.legs;
    }

    /**
     * @summary Returns top variable
     * 
     * @description Returns top private String variable from class Desk
     * 
     * @param
     * 
     * @return top
     */
    public String getTop() {
        return this.top;
    }

    /**
     * @summary Returns drawer variable
     * 
     * @description Returns drawer private String variable from class Desk
     * 
     * @param
     * 
     * @return drawer
     */
    public String getDrawer() {
        return this.drawer;
    }

    /**
     * @summary Returns furniture variable
     * 
     * @description Returns furniture private Furniture variable from class Desk
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
     * @description Sets legs private String variable from class Desk
     * 
     * @param legs
     * 
     * @return
     */
    public void setLegs(String legs) {
        this.legs = legs;
    }

    /**
     * @summary Sets top variable
     * 
     * @description Sets top private String variable from class Desk
     * 
     * @param top
     * 
     * @return
     */
    public void setTop(String top) {
        this.top = top;
    }

    /**
     * @summary Sets drawer variable
     * 
     * @description Sets drawer private String variable from class Desk
     * 
     * @param drawer
     * 
     * @return
     */
    public void setDrawer(String drawer) {
        this.drawer = drawer;
    }

    /**
     * @summary Sets furniture variable
     * 
     * @description Sets furniture private Furniture variable from class Desk
     * 
     * @param furniture
     * 
     * @return
     */
    public void setFurniture(Furniture furniture) {
        this.furniture = furniture;
    }

}