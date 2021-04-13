/**
 * @author Etienne Lagace <a
 * href="mailto:etienne.lagace@ucalgary.ca">etienne.lagace@ucalgary.ca</a>
 * @version 1.1
 * @since 1.0
 */

package edu.ucalgary.ensf409;

import java.sql.*;

/**
 * Manufacturer is a simple class that represents the MANUFACTURER table from
 * the INVENTORY query. It contains private String variables and an Integer
 * variable
 */
public class Manufacturer {

    private int manuID;
    private String name;
    private String phone;
    private String province;

    // Constructor
    public Manufacturer() {
    }

    /**
     * @summary Fills Manufacturer class with results from INVENTORY query
     * 
     * @description Uses ResultSet variable from SQL library to fill Manufacturer
     *              class with neccessary Strings and Integers
     * 
     * @param results
     * 
     * @return
     */
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
    /**
     * @summary Returns ManuID variable
     * 
     * @description Returns ManuID private Int variable from class Manufacturer
     * 
     * @param
     * 
     * @return ManuID
     */
    public int getManuID() {
        return this.manuID;
    }

    /**
     * @summary Returns name variable
     * 
     * @description Returns name private String variable from class Manufacturer
     * 
     * @param
     * 
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @summary Returns phone variable
     * 
     * @description Returns phone private String variable from class Manufacturer
     * 
     * @param
     * 
     * @return phone
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * @summary Returns province variable
     * 
     * @description Returns province private String variable from class Manufacturer
     * 
     * @param
     * 
     * @return province
     */
    public String getProvince() {
        return this.province;
    }

    // Setters
    /**
     * @summary Sets manuID variable
     * 
     * @description Sets manuID private Int variable from class Manufacturer
     * 
     * @param manuID
     * 
     * @return
     */
    public void setManuID(int manuID) {
        this.manuID = manuID;
    }

    /**
     * @summary Sets name variable
     * 
     * @description Sets name private String variable from class Manufacturer
     * 
     * @param name
     * 
     * @return
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @summary Sets phone variable
     * 
     * @description Sets phone private String variable from class Manufacturer
     * 
     * @param phone
     * 
     * @return
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @summary Sets province variable
     * 
     * @description Sets province private String variable from class Manufacturer
     * 
     * @param province
     * 
     * @return
     */
    public void setProvince(String province) {
        this.province = province;
    }

}
