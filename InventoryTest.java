import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;


public class InventoryTest {
    
    public InventoryTest(){
    }

    @Test

    public void test1Chair(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", "acaicedo", "Am201849538");
        testSQL.initializeConnection();
        int[] expected = {150, 10000, 400, 250, 225};
        ArrayList<Integer> a = new ArrayList<>();

        testSQL.populateFurniture("chair", "Task", 1); 
        a.add(testSQL.chain.getPrice().get(0));
        testSQL.populateFurniture("chair", "Kneeling", 1);
        a.add(testSQL.chain.getPrice().get(0));
        testSQL.populateFurniture("chair", "Executive", 1);
        a.add(testSQL.chain.getPrice().get(0));
        testSQL.populateFurniture("chair", "Ergonomic", 1);
        a.add(testSQL.chain.getPrice().get(0));
        testSQL.populateFurniture("chair", "Mesh", 1);
        a.add(testSQL.chain.getPrice().get(0));
        
        int [] actual = new int[a.size()];
        for (int i = 0; i < a.size(); i++){
            actual[i] = a.get(i);
        }

        assertTrue("Getting 1 chair of any type is not working properly", Arrays.equals(expected,actual));        
    }
    @Test

    public void test1Desk(){ 
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", "acaicedo", "Am201849538");
        testSQL.initializeConnection();
        int[] expected = {400, 300, 100};
        ArrayList<Integer> a = new ArrayList<>();

        testSQL.populateFurniture("desk", "Adjustable", 1); 
        a.add(testSQL.chain.getPrice().get(0));
        testSQL.populateFurniture("desk", "Standing", 1);
        a.add(testSQL.chain.getPrice().get(0));
        testSQL.populateFurniture("desk", "Traditional", 1);
        a.add(testSQL.chain.getPrice().get(0));

        int [] actual = new int[a.size()];
        for (int i = 0; i < a.size(); i++){
            actual[i] = a.get(i);
        }
        assertTrue("Getting 1 desk of any type is not working properly", Arrays.equals(expected,actual)); 
    } 
    
    @Test

    public void test1Lamp(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", "acaicedo", "Am201849538");
        testSQL.initializeConnection();
        int[] expected = {10, 30, 20};
        ArrayList<Integer> a = new ArrayList<>();

        testSQL.populateFurniture("lamp", "Study", 1); 
        a.add(testSQL.chain.getPrice().get(0));
        testSQL.populateFurniture("lamp", "Swing Arm", 1);
        a.add(testSQL.chain.getPrice().get(0));
        testSQL.populateFurniture("lamp", "Desk", 1);
        a.add(testSQL.chain.getPrice().get(0));
        
        int [] actual = new int[a.size()];
        for (int i = 0; i < a.size(); i++){
            actual[i] = a.get(i);
        }

        assertTrue("Getting 1 chair of any type is not working properly", Arrays.equals(expected,actual)); 
        
    }

    @Test
    public void test1Filing(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", "acaicedo", "Am201849538");
        testSQL.initializeConnection();
        int[] expected = {100, 200, 300};
        ArrayList<Integer> a = new ArrayList<>();

        testSQL.populateFurniture("filing", "Small", 1); 
        a.add(testSQL.chain.getPrice().get(0));
        testSQL.populateFurniture("filing", "Medium", 1);
        a.add(testSQL.chain.getPrice().get(0));
        testSQL.populateFurniture("filing", "Large", 1);
        a.add(testSQL.chain.getPrice().get(0));
        
        int [] actual = new int[a.size()];
        for (int i = 0; i < a.size(); i++){
            actual[i] = a.get(i);
        }
        assertTrue("Getting 1 chair of any type is not working properly", Arrays.equals(expected,actual)); 
    }

    @Test

    public void test2TaskChairs(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", "acaicedo", "Am201849538");
        testSQL.initializeConnection();
        Vector<Integer> expected = new Vector<>();
        expected.add(150);
        expected.add(10000);

        testSQL.populateFurniture("chair", "Task", 2); 
        Vector<Integer> actual = testSQL.chain.getPrice();

        assertTrue("Getting 2 task chairs of any type is not working properly", expected.equals(actual));        
    }

    @Test

    public void test2MeshChairs(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", "acaicedo", "Am201849538");
        testSQL.initializeConnection();
        Vector<Integer> expected = new Vector<>();
        expected.add(225);
        expected.add(10000);

        testSQL.populateFurniture("chair", "Mesh", 2); 
        Vector<Integer> actual = testSQL.chain.getPrice();

        assertTrue("Getting 2 Mesh chairs of any type is not working properly", expected.equals(actual));        
    }

    @Test

    public void test2ExecutiveChairs(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", "acaicedo", "Am201849538");
        testSQL.initializeConnection();
        Vector<Integer> expected = new Vector<>();
        expected.add(400);
        expected.add(10000);

        testSQL.populateFurniture("chair", "Executive", 2); 
        Vector<Integer> actual = testSQL.chain.getPrice();

        assertTrue("Getting 2 executive chairs of any type is not working properly", expected.equals(actual));        
    }

    @Test

    public void test2ErgonomicChairs(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", "acaicedo", "Am201849538");
        testSQL.initializeConnection();
        Vector<Integer> expected = new Vector<>();
        expected.add(250);
        expected.add(10000);

        testSQL.populateFurniture("chair", "Ergonomic", 2); 
        Vector<Integer> actual = testSQL.chain.getPrice();

        assertTrue("Getting 2 ergonomic chairs of any type is not working properly", expected.equals(actual));        
    }

    @Test

    public void test2KneelingChairs(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", "acaicedo", "Am201849538");
        testSQL.initializeConnection();
        Vector<Integer> expected = new Vector<>();
        expected.add(10000);

        testSQL.populateFurniture("chair", "Kneeling", 2); 
        Vector<Integer> actual = testSQL.chain.getPrice();

        assertTrue("Getting 2 kneeling chairs of any type is not working properly", expected.equals(actual));        
    }

    @Test
    public void testMaxAdjustableDesks(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", "acaicedo", "Am201849538");
        testSQL.initializeConnection();
        Vector<Integer> expected = new Vector<>();
        expected.add(400);
        expected.add(400);
        expected.add(400);

        testSQL.populateFurniture("desk", "Adjustable", 3); 
        Vector<Integer> actual = testSQL.chain.getPrice();

        assertTrue("Getting 1 chair of any type is not working properly", expected.equals(actual));        
    }

    @Test
    public void testMaxStandingDesks(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", "acaicedo", "Am201849538");
        testSQL.initializeConnection();
        Vector<Integer> expected = new Vector<>();
        expected.add(300);
        expected.add(300);
        expected.add(10000);

        testSQL.populateFurniture("desk", "Standing", 3); 
        Vector<Integer> actual = testSQL.chain.getPrice();

        assertTrue("Getting 1 chair of any type is not working properly", expected.equals(actual));        
    }

    @Test
    public void testMaxTraditionalDesks(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", "acaicedo", "Am201849538");
        testSQL.initializeConnection();
        Vector<Integer> expected = new Vector<>();
        expected.add(100);
        expected.add(125);

        
        testSQL.populateFurniture("desk", "Traditional", 3);
        System.out.println(testSQL.chain.getOverflow()); 
        Vector<Integer> actual = testSQL.chain.getPrice();

        assertTrue("Getting 1 chair of any type is not working properly", expected.equals(actual));        
    }

    @Test
    public void testMaxSmallFilings(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", "acaicedo", "Am201849538");
        testSQL.initializeConnection();
        Vector<Integer> expected = new Vector<>();
        expected.add(100);
        expected.add(125);
        expected.add(10000);

        testSQL.populateFurniture("filing", "Small", 3);
        System.out.println(testSQL.chain.getOverflow()); 
        Vector<Integer> actual = testSQL.chain.getPrice();

        assertTrue("Getting 1 chair of any type is not working properly", expected.equals(actual));        
    }

    @Test
    public void testMaxMediumFilings(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", "acaicedo", "Am201849538");
        testSQL.initializeConnection();
        Vector<Integer> expected = new Vector<>();
        expected.add(200);
        expected.add(200);
        expected.add(200);

        testSQL.populateFurniture("filing", "Medium", 4);
        System.out.println(testSQL.chain.getOverflow()); 
        Vector<Integer> actual = testSQL.chain.getPrice();

        assertTrue("Getting 1 chair of any type is not working properly", expected.equals(actual));        
    }

    @Test
    public void testMaxLargeFilings(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", "acaicedo", "Am201849538");
        testSQL.initializeConnection();
        Vector<Integer> expected = new Vector<>();
        expected.add(300);
        expected.add(300);
        expected.add(10000);

        testSQL.populateFurniture("filing", "Large", 3);
        System.out.println(testSQL.chain.getOverflow()); 
        Vector<Integer> actual = testSQL.chain.getPrice();

        assertTrue("Getting 1 chair of any type is not working properly", expected.equals(actual));        
    }

    @Test
    public void testMaxDeskLamp(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", "acaicedo", "Am201849538");
        testSQL.initializeConnection();
        Vector<Integer> expected = new Vector<>();
        expected.add(20);
        expected.add(20);
        expected.add(20);
        expected.add(10000);

        testSQL.populateFurniture("lamp", "Desk", 4);
        System.out.println(testSQL.chain.getOverflow()); 
        Vector<Integer> actual = testSQL.chain.getPrice();

        assertTrue("Getting 1 chair of any type is not working properly", expected.equals(actual));        
    }

    @Test
    public void testMaxSwingArmLamp(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", "acaicedo", "Am201849538");
        testSQL.initializeConnection();
        Vector<Integer> expected = new Vector<>();
        expected.add(30);
        expected.add(30);

        testSQL.populateFurniture("lamp", "Swing Arm", 4);
        System.out.println(testSQL.chain.getOverflow()); 
        Vector<Integer> actual = testSQL.chain.getPrice();

        assertTrue("Getting 1 chair of any type is not working properly", expected.equals(actual));        
    }

    @Test
    public void testMaxStudyLamp(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", "acaicedo", "Am201849538");
        testSQL.initializeConnection();
        Vector<Integer> expected = new Vector<>();
        expected.add(10);
        expected.add(10);
        expected.add(10000);

        testSQL.populateFurniture("lamp", "Study", 3);
        System.out.println(testSQL.chain.getOverflow()); 
        Vector<Integer> actual = testSQL.chain.getPrice();

        assertTrue("Getting 1 chair of any type is not working properly", expected.equals(actual));        
    }

}
