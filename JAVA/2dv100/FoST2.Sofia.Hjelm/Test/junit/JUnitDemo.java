/*
 * File: JUnitDemo.java
 * Author: Jonas Lundberg
 * Date: 4 feb 2014
 */
package Test.junit;


import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
 
/**
 * A JUnit test showing the order in which different methods are executed.
 * (Stolen from a JUnit tutorial found on the Internet.)
 * 
 * @author jlnmsi
 *
 */
public class JUnitDemo {
 
 
    @BeforeClass
    public static void oneTimeSetUp() {
        // one-time initialization code   
    	System.out.println("@BeforeClass - oneTimeSetUp");
    }
 
    @AfterClass
    public static void oneTimeTearDown() {
        // one-time cleanup code
    	System.out.println("@AfterClass - oneTimeTearDown");
    }
 
    @Before
    public void setUp() {
    	// Executed before each test method
        System.out.println("@Before - setUp");
    }
 
    @After
    public void tearDown() {
    	// Executed after each test method
        System.out.println("@After - tearDown");
    }
 
    @Test
    public void testMethod1() {
    	assertTrue(5==2+3);
        System.out.println("@Test - testMethod1");
    }
    
    @Test
    public void testMethod2() {
    	assertEquals("Hello","Hello");   // Uses equals() to compare
        System.out.println("@Test - testMethod2");
    }
    
    @Test
    public void testMethod3() {
    	assertNotSame(new Integer(5),new Integer(5));  // Uses != to compare
        System.out.println("@Test - testMethod3");
    }
 

}
