package edu.ucalgary.ensf409;

import java.io.*;
import java.util.Vector;

public class OrderForm {
    private String furniture;
    private int ammount;
    private Vector<String> ID;
    private int price = 0;

    public OrderForm() {
    }

    public OrderForm(String f, int a, Vector<String> ids, Vector<Integer> p) {
        this.furniture = f;
        this.ammount = a;
        this.ID = ids;

        int l = p.size();
        for (int i = 0; i < l; i++) {
            this.price += p.get(i);
        }
    }

    public void generateOrder() throws IOException {
        try {
            File myOutput = new File("order.txt");
            FileWriter myWriter = new FileWriter(myOutput);
            myWriter.write("Furniture Order Form\n\n");

            myWriter.write("Faculty Name:\n");
            myWriter.write("Contact:\n");
            myWriter.write("Date:\n\n");

            myWriter.write("Original Request: " + this.furniture + ", " + this.ammount + "\n\n");

            myWriter.write("Items Ordered\n");
            for (int i = 0; i < this.ID.size(); i++) {
                myWriter.write("ID: " + this.ID.get(i) + "\n");
            }

            myWriter.write("Total Price: $" + this.price);

            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred with IO.");
            e.printStackTrace();
        }
    }

    public String getFurniture() {
        return this.furniture;
    }

    public void setFurniture(String furniture) {
        this.furniture = furniture;
    }

    public int getAmmount() {
        return this.ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public Vector<String> getID() {
        return this.ID;
    }

    public void setID(Vector<String> ID) {
        this.ID = ID;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
