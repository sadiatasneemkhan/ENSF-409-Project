import edu.ucalgary.ensf409.*;
import java.sql.*;
import java.util.*;

public class Inventory {
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;
    private Connection dbConnect;
    private ResultSet results;
    private Management chain;

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
        } catch (SQLException e) {
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
            results = myStmt.executeQuery("SELECT * FROM manufacturer");

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

    public static void welcome() {
        System.out.println("Welcome!");
        System.out.println(
                "This program will need a connection to the inventory deatabase in order to function properly");
        System.out.println(
                "The purpose is to figure ou the cheapest and most sustainable option when choosing a new furniture item.");
        System.out.println(
                "All you need to specify is what type of item you want([lamp, filing, desk or chair) and how many you want");
        System.out.println(
                "**********************************************************************************************************");
    }

    public static void main(String[] args) {

        welcome();
        Scanner input = new Scanner(System.in);
        // System.out.println("Enter your username: ");
        // String userName = input.nextLine();
        // System.out.println("Enter your username: ");
        // String password = input.nextLine();
        input.close();

        // Inventory SQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY",
        // userName, password);
        Inventory SQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", "root", "BwNlEp200.23");

        SQL.initializeConnection();

        SQL.populateFurniture("DESK", "Adjustable", 2);

    }
}