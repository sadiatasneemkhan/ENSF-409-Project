import org.junit.*;
import static org.junit.Assert.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;


public class InventoryTest {

    public final String USERNAME = "acaicedo";
    public final String PASSWORD = "Am201849538";

    
    public InventoryTest(){
    }

    @Test
    public void test1Chair(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", USERNAME, PASSWORD);
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
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", USERNAME, PASSWORD);
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
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", USERNAME, PASSWORD);
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
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", USERNAME, PASSWORD);
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
    public void testMaxTaskChairs(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", USERNAME, PASSWORD);
        testSQL.initializeConnection();
        Vector<Integer> expected = new Vector<>();
        expected.add(150);

        testSQL.populateFurniture("chair", "Task", 1); 
        System.out.println(testSQL.chain.getOverflow()); 
        Vector<Integer> actual = testSQL.chain.getPrice();

        assertTrue("Getting 2 task chairs of any type is not working properly", expected.equals(actual));        
    }

    @Test
    public void testMaxMeshChairs(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", USERNAME, PASSWORD);
        testSQL.initializeConnection();
        Vector<Integer> expected = new Vector<>();
        expected.add(225);

        testSQL.populateFurniture("chair", "Mesh", 1);
        System.out.println(testSQL.chain.getOverflow());  
        Vector<Integer> actual = testSQL.chain.getPrice();

        assertTrue("Getting 2 Mesh chairs of any type is not working properly", expected.equals(actual));        
    }

    @Test
    public void testMaxExecutiveChairs(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", USERNAME, PASSWORD);
        testSQL.initializeConnection();
        Vector<Integer> expected = new Vector<>();
        expected.add(400);

        testSQL.populateFurniture("chair", "Executive", 1);
        System.out.println(testSQL.chain.getOverflow());  
        Vector<Integer> actual = testSQL.chain.getPrice();

        assertTrue("Getting 2 executive chairs of any type is not working properly", expected.equals(actual));        
    }

    @Test
    public void testMaxErgonomicChairs(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", USERNAME, PASSWORD);
        testSQL.initializeConnection();
        Vector<Integer> expected = new Vector<>();
        expected.add(250);

        testSQL.populateFurniture("chair", "Ergonomic", 1);
        System.out.println(testSQL.chain.getOverflow());  
        Vector<Integer> actual = testSQL.chain.getPrice();

        assertTrue("Getting 2 ergonomic chairs of any type is not working properly", expected.equals(actual));        
    }


    @Test
    public void testMaxAdjustableDesks(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", USERNAME, PASSWORD);
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
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", USERNAME, PASSWORD);
        testSQL.initializeConnection();
        Vector<Integer> expected = new Vector<>();
        expected.add(300);
        expected.add(300);

        testSQL.populateFurniture("desk", "Standing", 2); 
        Vector<Integer> actual = testSQL.chain.getPrice();

        assertTrue("Getting 1 chair of any type is not working properly", expected.equals(actual));        
    }

    @Test
    public void testMaxTraditionalDesks(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", USERNAME, PASSWORD);
        testSQL.initializeConnection();
        Vector<Integer> expected = new Vector<>();
        expected.add(100);
        expected.add(125);

        testSQL.populateFurniture("desk", "Traditional", 2);
        System.out.println(testSQL.chain.getOverflow()); 
        Vector<Integer> actual = testSQL.chain.getPrice();

        assertTrue("Getting 1 chair of any type is not working properly", expected.equals(actual));        
    }

    @Test
    public void testMaxSmallFilings(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", USERNAME, PASSWORD);
        testSQL.initializeConnection();
        Vector<Integer> expected = new Vector<>();
        expected.add(100);
        expected.add(125);

        testSQL.populateFurniture("filing", "Small", 2);
        System.out.println(testSQL.chain.getOverflow()); 
        Vector<Integer> actual = testSQL.chain.getPrice();

        assertTrue("Getting 1 chair of any type is not working properly", expected.equals(actual));        
    }

    @Test
    public void testMaxMediumFilings(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", USERNAME, PASSWORD);
        testSQL.initializeConnection();
        Vector<Integer> expected = new Vector<>();
        expected.add(200);
        expected.add(200);
        expected.add(200);

        testSQL.populateFurniture("filing", "Medium", 3);
        System.out.println(testSQL.chain.getOverflow()); 
        Vector<Integer> actual = testSQL.chain.getPrice();

        assertTrue("Getting 1 chair of any type is not working properly", expected.equals(actual));        
    }

    @Test
    public void testMaxLargeFilings(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", USERNAME, PASSWORD);
        testSQL.initializeConnection();
        Vector<Integer> expected = new Vector<>();
        expected.add(300);
        expected.add(300);

        testSQL.populateFurniture("filing", "Large", 2);
        System.out.println(testSQL.chain.getOverflow()); 
        Vector<Integer> actual = testSQL.chain.getPrice();

        assertTrue("Getting 1 chair of any type is not working properly", expected.equals(actual));        
    }

    @Test
    public void testMaxDeskLamp(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", USERNAME, PASSWORD);
        testSQL.initializeConnection();
        Vector<Integer> expected = new Vector<>();
        expected.add(20);
        expected.add(20);
        expected.add(20);

        testSQL.populateFurniture("lamp", "Desk", 3);
        System.out.println(testSQL.chain.getOverflow()); 
        Vector<Integer> actual = testSQL.chain.getPrice();

        assertTrue("Getting 1 chair of any type is not working properly", expected.equals(actual));        
    }

    @Test
    public void testMaxSwingArmLamp(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", USERNAME, PASSWORD);
        testSQL.initializeConnection();
        Vector<Integer> expected = new Vector<>();
        expected.add(30);
        expected.add(30);

        testSQL.populateFurniture("lamp", "Swing Arm", 2);
        System.out.println(testSQL.chain.getOverflow()); 
        Vector<Integer> actual = testSQL.chain.getPrice();

        assertTrue("Getting 1 chair of any type is not working properly", expected.equals(actual));        
    }

    @Test
    public void testMaxStudyLamp(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", USERNAME, PASSWORD);
        testSQL.initializeConnection();
        Vector<Integer> expected = new Vector<>();
        expected.add(10);
        expected.add(10);

        testSQL.populateFurniture("lamp", "Study", 2);
        System.out.println(testSQL.chain.getOverflow()); 
        Vector<Integer> actual = testSQL.chain.getPrice();

        assertTrue("Getting 1 chair of any type is not working properly", expected.equals(actual));        
    }

    @Test
    public void testOverflowAll(){
        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", USERNAME, PASSWORD);
        testSQL.initializeConnection();
        Vector<Boolean> actual = new Vector<>();
        int overflow = 100;

        testSQL.populateFurniture("chair", "Task", overflow); 
        actual.add(testSQL.chain.getOverflow());
        testSQL.populateFurniture("chair", "Kneeling", overflow);
        actual.add(testSQL.chain.getOverflow());
        testSQL.populateFurniture("chair", "Executive", overflow);
        actual.add(testSQL.chain.getOverflow());
        testSQL.populateFurniture("chair", "Ergonomic", overflow);
        actual.add(testSQL.chain.getOverflow());
        testSQL.populateFurniture("chair", "Mesh", overflow);
        actual.add(testSQL.chain.getOverflow());

        testSQL.populateFurniture("desk", "Traditional", overflow); 
        actual.add(testSQL.chain.getOverflow());
        testSQL.populateFurniture("desk", "Adjustable", overflow);
        actual.add(testSQL.chain.getOverflow());
        testSQL.populateFurniture("desk", "Standing", overflow);
        actual.add(testSQL.chain.getOverflow());

        testSQL.populateFurniture("filing", "Small", overflow); 
        actual.add(testSQL.chain.getOverflow());
        testSQL.populateFurniture("filing", "Medium", overflow);
        actual.add(testSQL.chain.getOverflow());
        testSQL.populateFurniture("filing", "Large", overflow);
        actual.add(testSQL.chain.getOverflow());

        testSQL.populateFurniture("lamp", "Desk", overflow); 
        actual.add(testSQL.chain.getOverflow());
        testSQL.populateFurniture("lamp", "Study", overflow);
        actual.add(testSQL.chain.getOverflow());
        testSQL.populateFurniture("lamp", "Swing Arm", overflow);
        actual.add(testSQL.chain.getOverflow());

        Vector<Boolean> expected = new Vector<>();
        for (int i = 0; i < actual.size(); i++){
            expected.add(true);
        }
        assertTrue("Testing overflow does not yeild expected result", expected.equals(actual)); 
    }

    @Test
    public void testDeleteFromDatabase(){

        Inventory testSQL = new Inventory("jdbc:mysql://localhost:3306/INVENTORY", USERNAME, PASSWORD);
        testSQL.initializeConnection();

        testSQL.populateFurniture("chair", "Task", 1);
        int before = testSQL.chain.getIDVector().size();

        for (int i = 0; i < testSQL.chain.getIDVector().size(); i++){
            testSQL.deleteFurniture(testSQL.chain.getIDVector().get(i));
        }

        testSQL.populateFurniture("chair", "Task", 1);
        int after = testSQL.chain.getIDVector().size();

        assertFalse("Delete function not working properly", before == after);
    }
    

}
