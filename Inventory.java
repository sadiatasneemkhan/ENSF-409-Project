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

import edu.ucalgary.ensf409.*;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.*;

/**
 * Inventory is one of two main classes for this supply chain management
 * project. It manages user inputs using the imported scanner class and library,
 * uses said variables to populate a variable of class Management, and declares
 * a method to find the cheapest combination of parts for any category and type
 * of furniture.
 * 
 * This class utilizes an SQL library to access the users querys and pulls
 * tables from the INVENTORY query. It uses a variable of class ResultSet to
 * aquire and distribute the information found in the given tables and can
 * delete any row from the given table using the ID.
 */
public class Inventory {
    public final String DBURL;
    public static final String USERNAME;
    public static final String PASSWORD;
    private Connection dbConnect;
    private ResultSet results;
    protected Management chain;
    private OrderForm orderForm;
    public static boolean validFurniture = false;
    public static boolean validType = false;
    public static boolean validInt = false;
    private final static String REGEX = "\\d*";
    private static final Pattern PATTERN = Pattern.compile(REGEX);
    public static String furniture;
    public static String type;
    public static int intAmount;

    /**
     * @summary Fills Inventory class to access SQL query
     * 
     * @description Uses the users username and password paired with the admin given
     *              DBURL to access the INVENTORY query
     * 
     * @param DBURL - database URL
     * @param USERNAME - SQL username of the user engaging with the program
     * @param PASSWORD - SQL password
     * 
     * @return
     */
    public Inventory(String DBURL) {
        this.DBURL = DBURL;
    }

    /**
     * @summary Returns DBURL variable
     * 
     * @description Returns DBURL private String variable from class Inventory
     * 
     * @param
     * 
     * @return database URL
     */
    public String getDBURL() {
        return DBURL;
    }

    /**
     * @summary Returns USERNAME variable
     * 
     * @description Returns USERNAME private String variable from class Inventory
     * 
     * @param
     * 
     * @return username
     */
    public String getUSERNAME() {
        return USERNAME;
    }

    /**
     * @summary Returns PASSWORD variable
     * 
     * @description Returns PASSWORD private String variable from class Inventory
     * 
     * @param
     * 
     * @return PASSWORD
     */
    public String getPASSWORD() {
        return PASSWORD;
    }


    /**
     * @summary Initializes the connection to a SQL query
     * 
     * @description Initializes the connection to the INVENTORY SQL query using the
     *              users username and passowrd
     * 
     * @param
     * 
     * @return
     */
    public void initializeConnection() {
        try {
            dbConnect = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            System.out.println("Connection established successfully!");
        } catch (SQLException e) {
            System.out.println("Connection unsucessful");
            e.printStackTrace();
        }
    }

    /**
     * @summary Receives user input for furniture category, type, and the number of
     *          items requested and uses given information to initialize a variable
     *          of class Management, call a method to find the lowest combination of
     *          parts, and call a method to delete the identified furniture items
     * 
     * @description Returns DBURL private String variable from class Inventory
     * 
     * @param furniture category
     * @param furniture type
     * @param number of requested items
     * 
     * @return
     */
    public void populateFurniture(String category, String type, int items) {
        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM " + category);

            // initializes and populates the variable chain with the found items
            chain = new Management(results, category, type);

            // used to record the manufacturers to contact for the requested type or
            // furniture
            setManufacturer();

            // used to search through each item and find the best combination of parts for
            // the lowest price
            chain.combination(items);

            System.out.println(chain.getPrice());
            System.out.println(chain.getIndex());
            System.out.println(chain.getIDString());
            System.out.println(chain.getManuNames());

            // int l = chain.getIDVector().size();
            // for (int i = 0; i < l; i++) {
            //     deleteFurniture(chain.getIDVector().get(i));
            // }

            // closes myStmt variable
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @summary Retrieves MANUFACTURER table from INVENTORY query populates chain
     *          variable
     * 
     * @description Uses a variable of type ResultSet to obtain values found in the
     *              MANUFACTURER table from the INVENTORY query and passes said
     *              variable to a variable of class Management. These stored values
     *              are later used to determine which manufacturers to contact if
     *              the user request caused an overflow
     * 
     * @param
     * 
     * @return
     */
    public void setManufacturer() {
        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM MANUFACTURER");

            while (results.next()) {
                chain.setManufacturer(results);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @summary Deletes rows from a table found in the INVENTORY query using IDs
     * 
     * @description Uses the found IDs of furniture item combinations to delete the
     *              furniture item from the INVENTORY query
     * 
     * @param ID
     * 
     * @return
     */
    public void deleteFurniture(String ID) {
        try {
            String query = new String();

            // switch required to know which table needs to delete a row
            switch (chain.getPriority()) {
            case 0:
                query = "DELETE FROM CHAIR WHERE ID = ?";
                break;
            case 1:
                query = "DELETE FROM DESK WHERE ID = ?";
                break;
            case 2:
                query = "DELETE FROM FILING WHERE ID = ?";
                break;
            case 3:
                query = "DELETE FROM LAMP WHERE ID = ?";
                break;
            }

            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.setString(1, ID);
            myStmt.executeUpdate();
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @summary Closes variables used to access SQL queries
     * 
     * @description Closes varibles retults and dbConnect
     * 
     * @param
     * 
     * @return
     */
    public void close() {
        try {
            results.close();
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @summary Prints message to user through terminal
     * 
     * @description Prints introductory message to user informing them the program
     *              has been activated and what the purpose of the program is
     * 
     * @param
     * 
     * @return
     */
    public static void welcomeMessege() {
        System.out.println("Welcome!");
        System.out.println(
                "This program will need a connection to the inventory database (jdbc:mysql://localhost:3306/inventory)");
        System.out.println(
                "The purpose is to figure out the cheapest and most sustainable option when choosing a new furniture item.");
        System.out.println(
                "All you need to specify is what furniture of item (lamp, filing, desk or chair), the type, and how many you want.");
        System.out.println(
                "***************************************************************************************************************");
    }


    

    public static void userPrompt() {
        Scanner sc = new Scanner(System.in);
        int intAmount;
        System.out.println("Enter your username: ");
        USERNAME = sc.nextLine();
        System.out.println("Enter your password: ");
        PASSWORD = sc.nextLine();

        System.out.println("What kind of furniture do you want?: ");
        String furniture = sc.nextLine();
        checkValidFurniture(furniture);
        if (!validFurniture)
        {
            while (!validFurniture) {
                System.out.println("Please enter a valid furniture item i.e. lamp, desk, filing or chair");
                furniture = sc.nextLine();
                checkValidFurniture(furniture);
            }
        }

        System.out.println("What type of " + furniture + " would you like?: ");
        String type = sc.nextLine();
        checkValidType (furniture, type);
        if (!validType)
        {
            while (!validType)
            {
                System.out.println("Please enter a valid type for the " + furniture);
                type = sc.nextLine();
                checkValidType(furniture, type);
            }
        }


        System.out.println("How many would you like? (Please enter a valid integer): ");
        String amount = sc.nextLine();
        checkValidQuantity(amount);
        if (!validInt)
        { while(!validInt) {
            System.out.println("Please enter a valid integer");
            amount = sc.nextLine();
            checkValidQuantity(amount);
        }
        }
        else if (validInt == true) {
            intAmount = Integer.parseInt(amount);
        }

        sc.close();
    }

    public static void checkValidFurniture(String furniture) {
        // cycles to ensure proper furniture category was supplied by the user

        if (furniture.equalsIgnoreCase("chair") || furniture.equalsIgnoreCase("desk")
                    || furniture.equalsIgnoreCase("lamp") || furniture.equalsIgnoreCase("filing")) {
                validFurniture = true;
                    }
    }
    

    public static void checkValidType(String furniture, String type) {
        // cycles to ensure proper furniture type was supplied by the user
            if (furniture.equalsIgnoreCase("chair") && (type.equalsIgnoreCase("task") || type.equalsIgnoreCase("mesh")
                    || type.equalsIgnoreCase("executive") || type.equalsIgnoreCase("Kneeling")
                    || type.equalsIgnoreCase("ergonomic"))) {
                validType = true;
            } else if (furniture.equalsIgnoreCase("desk") && (type.equalsIgnoreCase("traditional")
                    || type.equalsIgnoreCase("adjustable") || type.equalsIgnoreCase("standing"))) {
                validType = true;
            } else if (furniture.equalsIgnoreCase("lamp") && (type.equalsIgnoreCase("desk")
                    || type.equalsIgnoreCase("swing arm") || type.equalsIgnoreCase("study"))) {
                validType = true;
            } else if (furniture.equalsIgnoreCase("filing") && (type.equalsIgnoreCase("small")
                    || type.equalsIgnoreCase("medium") || type.equalsIgnoreCase("large"))) {
                validType = true;
            }

    }

    public static void checkValidQuantity(String amount) {
        Matcher matcher = PATTERN.matcher(amount);
        if (matcher.find()) {
            validInt = true;
        }
    }

    /**
     * @summary Retrieves user inputs and uses them to populate a variable of class
     *          Inventory and call a function to initiaze a variable of class
     *          OrderForm
     * 
     * @description Uses the imported scanner class and library to obtain user
     *              inputs for username and password, as well as the furniture
     *              category, type, and the number of items requested. Questions to
     *              obtain user inputs will cycle until a correct input is detected.
     *              Once a number of ID's for items and an optimal price have been
     *              found or an overflow has occured, a variable of class OrderForm
     *              will be initialized to create an order form for the user
     * 
     * @param args
     * 
     * @return
     */
    public static void main(String[] args) throws IOException {

        // prints welcome message to terminal
        welcomeMessege();
        // ensure proper furniture category was supplied by the user
        userPrompt();

        // accesses INVENTORY query
        Inventory SQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY");
        SQL.initializeConnection();

        
        // begins populating process
        SQL.populateFurniture(furniture, type, intAmount);

        // Initialize variable
        SQL.orderForm = new OrderForm(furniture, intAmount, SQL.chain.getIDVector(), SQL.chain.getPrice(),
                SQL.chain.getManuNames(), type, SQL.chain.getOverflow());

        // Creates order form for the user
        SQL.orderForm.generateOrder();

    }
}
