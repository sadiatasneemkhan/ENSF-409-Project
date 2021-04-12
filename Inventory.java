import edu.ucalgary.ensf409.*;

import java.io.IOException;
import java.sql.*;
import java.util.*;


public class Inventory {
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;
    private Connection dbConnect;
    private ResultSet results;
    private Management chain;
    private OrderForm orderForm;

    public Inventory(String DBURL, String USERNAME, String PASSWORD) {
        this.DBURL = DBURL;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
    }

    public String getDBURL() {
        return DBURL;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void initializeConnection() {
        try {
            dbConnect = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            System.out.println("Connection established successfully!");
        } catch (SQLException e) {
            System.out.println("Connection unsucessful");
            e.printStackTrace();
        }
    }

    public void populateFurniture(String category, String type, int items) {
        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM " + category);
            chain = new Management(results, category, type);

            setManufacturer();

            chain.printParts();

            chain.combination(items);

            System.out.println(chain.getPrice());
            System.out.println(chain.getIndex());
            System.out.println(chain.getIDString());
            System.out.println(chain.getManuNames());

            int l = chain.getIDVector().size();
            for (int i = 0; i < l; i++) {
                deleteFurniture(chain.getIDVector().get(i));
            }

            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setManufacturer() {
        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM MANUFACTURER");

            while (results.next()) {
                chain.setManufacturer(results);
            }

            System.out.println(chain.getManufacturer().get(3).getName());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFurniture(String ID) {
        try {
            String query = new String();

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

            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void close() {
        try {
            results.close();
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void welcomeMessege() {
        System.out.println("Welcome!");
        System.out.println(
                "This program will need a connection to the inventory database (jdbc:mysql://localhost:3306/inventory)");
        System.out.println(
                "The purpose is to figure out the cheapest and most sustainable option when choosing a new furniture item.");
        System.out.println(
                "All you need to specify is what furniture of item (lamp, filing, desk or chair), the type and how many you want");
        System.out.println(
                "***************************************************************************************************************");
    }

    public static void main(String args[]) throws IOException {
        boolean validfurniture = false, validType = false;

        welcomeMessege();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your username: ");
        String userName = sc.nextLine();
        System.out.println("Enter your password: ");
        String password = sc.nextLine();

        Inventory SQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", userName, password);
        SQL.initializeConnection();

        System.out.println("What kind of furniture do you want?: ");
        String furniture = sc.nextLine();
        while (!validfurniture){
            if(furniture.equalsIgnoreCase("chair")||furniture.equalsIgnoreCase("desk")||furniture.equalsIgnoreCase("lamp")||furniture.equalsIgnoreCase("filing")){
                validfurniture = true;
            }
            else{
                System.out.println("Please enter a valid furniture item i.e. lamp, desk, filing or chair");
                furniture = sc.nextLine();
            }
        }

        System.out.println("What type of "+ furniture +" would you like?: ");
        String type = sc.nextLine();
        while (!validType){
            if(furniture.equalsIgnoreCase("chair")&&type.equalsIgnoreCase("task")||type.equalsIgnoreCase("mesh")
            ||type.equalsIgnoreCase("executive")||type.equalsIgnoreCase("Kneeling")||type.equalsIgnoreCase("ergonomic")){
                validType = true;
            }
            else if(furniture.equalsIgnoreCase("desk")&&type.equalsIgnoreCase("traditional")
            ||type.equalsIgnoreCase("adjustable")||type.equalsIgnoreCase("standing")){
                validType = true;
            }
            else if(furniture.equalsIgnoreCase("lamp")&&type.equalsIgnoreCase("desk")||
            type.equalsIgnoreCase("swing arm")||type.equalsIgnoreCase("study")){
                validType = true;
            }
            else if(furniture.equalsIgnoreCase("filing")&&type.equalsIgnoreCase("small")
            ||type.equalsIgnoreCase("medium")||type.equalsIgnoreCase("large")){
                validType = true;
            }
            else{
                System.out.println("Please enter a valid type for the "+furniture);
                type = sc.nextLine();
            }
        }

        System.out.println("How many would you like? (Please enter a valid integer): ");
        int ammount = sc.nextInt();

        sc.close();
        SQL.populateFurniture(furniture, type, ammount);
        
        System.out.println(SQL.chain.getManuNames());
        
        SQL.orderForm = new OrderForm(furniture, ammount, SQL.chain.getIDVector(), SQL.chain.getPrice().get(0));

        SQL.orderForm.generateOrder();

    }
}