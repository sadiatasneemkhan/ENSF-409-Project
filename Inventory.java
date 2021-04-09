import edu.ucalgary.ensf409.*;
import java.sql.*;
import java.util.*;
import java.io.*;

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

            chain.printChair();
            chain.printDesk();
            chain.printFiling();
            chain.printLamp();

            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
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

    public static void main(String args[]) {
        Inventory SQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", "root", "BwNlEp200.23");

        SQL.initializeConnection();

        SQL.populateFurniture("Filing", "Medium", 1);
    }
}
