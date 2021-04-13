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
 * Filing is a simple class that represents the furniture item FILING from the
 * INVENTORY query. It contains a private String variables for each part and a
 * Funiture variable for all common columns of each furniture category
 */
public class Filing {

    private String rails;
    private String drawers;
    private String cabinet;
    private Furniture furniture;

    // Constructor
    public Filing() {
    }

    /**
     * @summary Fills Filing class with results from INVENTORY query
     * 
     * @description Uses ResultSet variable from SQL library to fill Filing class
     *              with neccessary Strings for parts and sends the rest of the
     *              ResultSet variable to initialize a Funiture class item
     * 
     * @param results from ResultSet object
     * 
     * @return
     */
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
    /**
     * @summary Returns rails variable
     * 
     * @description Returns rails private String variable from class Filing
     * 
     * @param
     * 
     * @return rails
     */
    public String getRails() {
        return this.rails;
    }

    /**
     * @summary Returns drawers variable
     * 
     * @description Returns drawers private String variable from class Filing
     * 
     * @param
     * 
     * @return drawers
     */
    public String getDrawers() {
        return this.drawers;
    }

    /**
     * @summary Returns cabinet variable
     * 
     * @description Returns cabinet private String variable from class Filing
     * 
     * @param
     * 
     * @return cabinet
     */
    public String getCabinet() {
        return this.cabinet;
    }

    /**
     * @summary Returns furniture variable
     * 
     * @description Returns furniture private Furniture variable from class Filing
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
     * @summary Sets rails variable
     * 
     * @description Sets rails private String variable from class Filing
     * 
     * @param rails
     * 
     * @return
     */
    public void setRails(String rails) {
        this.rails = rails;
    }

    /**
     * @summary Sets drawers variable
     * 
     * @description Sets drawers private String variable from class Filing
     * 
     * @param drawers
     * 
     * @return
     */
    public void setDrawers(String drawers) {
        this.drawers = drawers;
    }

    /**
     * @summary Sets cabinet variable
     * 
     * @description Sets cabinet private String variable from class Filing
     * 
     * @param cabinet
     * 
     * @return
     */
    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }

    /**
     * @summary Sets furniture variable
     * 
     * @description Sets furniture private Furniture variable from class Filing
     * 
     * @param furniture
     * 
     * @return
     */
    public void setFurniture(Furniture furniture) {
        this.furniture = furniture;
    }

}
