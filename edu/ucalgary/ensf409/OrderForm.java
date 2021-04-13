/**
 * @author Etienne Lagace <a
 * href="mailto:etienne.lagace@ucalgary.ca">etienne.lagace@ucalgary.ca</a>
 * @version 1.2
 * @since 1.0
 */

package edu.ucalgary.ensf409;

import java.io.*;
import java.util.Vector;

/**
 * OrderForm is a simple class that produces the formatted order form in a .txt
 * format. It contains private variables for all necessary information outputed
 * to the .txt file.
 */

public class OrderForm {
    private String furniture;
    private String type;
    private String manufacturer;
    private Boolean overflow;
    private int amount;
    private int price = 0;
    private Vector<String> ID;

    // Constructor
    public OrderForm() {
    }

    /**
     * @summary Fills OrderForm class with results from user input
     * 
     * @description Uses stored user input values and SQL library to initialize all
     *              the fields of the OrderForm class
     * 
     * @param f
     * @param amount
     * @param ID
     * @param price
     * @param manufacturer
     * @param tyoe
     * @param overflow
     * 
     * @return
     */
    public OrderForm(String filing, int amount, Vector<String> ID, Vector<Integer> price, String manufacturer,
            String type, Boolean overflow) {
        this.furniture = filing;
        this.type = type;
        this.manufacturer = manufacturer;
        this.overflow = overflow;
        this.amount = amount;
        this.ID = ID;

        int l = price.size();
        for (int i = 0; i < l; i++) {
            this.price += price.get(i);
        }
    }

    // Generate order form
    /**
     * @summary Generates an order form for the user
     * 
     * @description Uses FileWriter class to write to an output file named
     *              order.txt. Faculty name, contact, and date written and left
     *              blank for the user to fill. Furniture type, category, and price
     *              of order are outputted if possible and an "order could not be
     *              fulfilled" text is ouputted if overflow was detected from the
     *              overflow boolean
     * 
     * @param
     * 
     * @return
     */
    public void generateOrder() throws IOException {
        try {
            File myOutput = new File("order.txt");
            FileWriter myWriter = new FileWriter(myOutput);
            myWriter.write("Furniture Order Form\n\n");

            myWriter.write("Faculty Name:\n");
            myWriter.write("Contact:\n");
            myWriter.write("Date:\n\n");

            // Output furniture type, category, and price of order
            myWriter.write("Original Request: " + this.type + " " + this.furniture + ", " + this.amount + "\n\n");

            // ID vector is check for emptiness to know whether IDs for furniture were found
            // or not
            if (!ID.isEmpty()) {
                myWriter.write("Items Ordered\n");

                // Iterates through ID vector to get every ID
                for (int i = 0; i < this.ID.size(); i++) {
                    myWriter.write("ID: " + this.ID.get(i) + "\n");
                }
                myWriter.write("Total Price: $" + this.price);

                // checks for overflow for correct formatting of the order.txt file
                if (overflow) {
                    myWriter.write("\n\n");
                }

            }

            // checks for overflow to know whether or not an "order could not be fulfilled"
            // message should be sent
            if (overflow) {
                myWriter.write("Complete order could not be fulfilled based on current inventory.\n");
                myWriter.write("Try reducing the amount of furniture requested or visit any of these manufacturers:\n");
                myWriter.write(manufacturer);
            }

            myWriter.write("\n\nThank you, come again :)");

            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred with IO.");
            e.printStackTrace();
        }
    }

    // Getters
    /**
     * @summary Returns furniture variable
     * 
     * @description Returns furniture private String variable from class OrderForm
     * 
     * @param
     * 
     * @return furniture
     */
    public String getFurniture() {
        return this.furniture;
    }

    /**
     * @summary Returns type variable
     * 
     * @description Returns type private String variable from class OrderForm
     * 
     * @param
     * 
     * @return type
     */
    public String getType() {
        return this.type;
    }

    /**
     * @summary Returns manufacturer variable
     * 
     * @description Returns manufacturer private String variable from class
     *              OrderForm
     * 
     * @param
     * 
     * @return manufacturer
     */
    public String getManufacturer() {
        return this.manufacturer;
    }

    /**
     * @summary Returns overflow variable
     * 
     * @description Returns overflow private Boolean variable from class OrderForm
     * 
     * @param
     * 
     * @return overflow
     */
    public Boolean getOverflow() {
        return this.overflow;
    }

    /**
     * @summary Returns amount variable
     * 
     * @description Returns amount private Int variable from class OrderForm
     * 
     * @param
     * 
     * @return amount
     */
    public int getAmount() {
        return this.amount;
    }

    /**
     * @summary Returns price variable
     * 
     * @description Returns price private Int variable from class OrderForm
     * 
     * @param
     * 
     * @return price
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * @summary Returns ID variable
     * 
     * @description Returns ID private Vector<String> variable from class OrderForm
     * 
     * @param
     * 
     * @return ID
     */
    public Vector<String> getID() {
        return this.ID;
    }

    // Setters
    /**
     * @summary Sets furniture variable
     * 
     * @description Sets furniture private String variable from class OrderForm
     * 
     * @param furniture
     * 
     * @return
     */
    public void setFurniture(String furniture) {
        this.furniture = furniture;
    }

    /**
     * @summary Sets type variable
     * 
     * @description Sets type private String variable from class OrderForm
     * 
     * @param type
     * 
     * @return
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @summary Sets manufacturer variable
     * 
     * @description Sets manufacturer private String variable from class OrderForm
     * 
     * @param manufacturer
     * 
     * @return
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * @summary Sets overflow variable
     * 
     * @description Sets overflow private Boolean variable from class OrderForm
     * 
     * @param overflow
     * 
     * @return
     */
    public void setOverflow(Boolean overflow) {
        this.overflow = overflow;
    }

    /**
     * @summary Sets amount variable
     * 
     * @description Sets amount private Int variable from class OrderForm
     * 
     * @param amount
     * 
     * @return
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * @summary Sets price variable
     * 
     * @description Sets price private Int variable from class OrderForm
     * 
     * @param price
     * 
     * @return
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @summary Sets ID variable
     * 
     * @description Sets ID private Vector<String> variable from class OrderForm
     * 
     * @param ID
     * 
     * @return
     */
    public void setID(Vector<String> ID) {
        this.ID = ID;
    }
}
