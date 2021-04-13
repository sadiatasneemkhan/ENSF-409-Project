/** 
 * @author Etienne Lagace <a>
 * href="mailto:etienne.lagace@ucalgary.ca">etienne.lagace@ucalgary.ca</a>
 * @author Haniya Ahmed <a>
 * href="mailto:haniya.ahmed@ucalgary.ca">haniya.ahmed@ucalgary.ca</a>
 * @author Sadia Khan <a>
 * href="mailto:sadia.khan1@ucalgary.ca">sadia.khan1@ucalgary.ca</a>
 * @author Andres Caicedo <a>
 * href="mailto:acaicedo@ucalgary.ca">acaicedo@ucalgary.ca.ca</a>
 * @version 1.2
 * @since 1.0
 */

package edu.ucalgary.ensf409;

import java.sql.*;

/**
 * Lamp is a simple class that represents the furniture item LAMP from the
 * INVENTORY query. It contains a private String variables for each part and a
 * Funiture variable for all common columns of each furniture category
 */
public class Lamp {

    private String base;
    private String bulb;
    private Furniture furniture;

    // Constructor
    public Lamp() {
    }

    /**
     * @summary Fills Lamp class with results from INVENTORY query
     * 
     * @description Uses ResultSet variable from SQL library to fill Lamp class with
     *              neccessary Strings for parts and sends the rest of the ResultSet
     *              variable to initialize a Funiture class item
     * 
     * @param results from ResultSet object
     * 
     * @return
     */
    public Lamp(ResultSet results) {
        try {
            this.base = results.getString("Base");
            this.bulb = results.getString("Bulb");
            this.furniture = new Furniture(results);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Getters
    /**
     * @summary Returns base variable
     * 
     * @description Returns base private String variable from class Lamp
     * 
     * @param
     * 
     * @return base
     */
    public String getBase() {
        return this.base;
    }

    /**
     * @summary Returns bulb variable
     * 
     * @description Returns bulb private String variable from class Lamp
     * 
     * @param
     * 
     * @return bulb
     */
    public String getBulb() {
        return this.bulb;
    }

    /**
     * @summary Returns furniture variable
     * 
     * @description Returns furniture private Furniture variable from class Lamp
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
     * @summary Sets base variable
     * 
     * @description Sets base private String variable from class Lamp
     * 
     * @param base
     * 
     * @return
     */
    public void setBase(String base) {
        this.base = base;
    }

    /**
     * @summary Sets bulb variable
     * 
     * @description Sets bulb private String variable from class Lamp
     * 
     * @param bulb
     * 
     * @return
     */
    public void setBulb(String bulb) {
        this.bulb = bulb;
    }

    /**
     * @summary Sets furniture variable
     * 
     * @description Sets furniture private Furniture variable from class Lamp
     * 
     * @param furniture
     * 
     * @return
     */
    public void setFurniture(Furniture furniture) {
        this.furniture = furniture;
    }

}
