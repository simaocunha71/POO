package casainteligente;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class SmartDeviceTest.
 *
 * @author  Tiago Silva and Simão Cunha
 * @version 14/4/2021
 */


public class SmartDeviceTest {

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
        @Test
    public void testContructor() {
        SmartDevice smartDev1 = new SmartDevice();
        assertTrue(smartDev1!=null);
        smartDev1 = new SmartDevice("b1");
        assertTrue(smartDev1!=null);
        smartDev1 = new SmartDevice("b1", true);
        assertTrue(smartDev1!=null);
    }
    
    @Test
    public void testGetID() {
        SmartDevice smartDev1 = new SmartDevice();
        assertEquals("", smartDev1.getID());
        smartDev1 = new SmartDevice("b1");
        assertEquals("b1", smartDev1.getID());
    }
    
    @Test
    public void testGetOn() {
        SmartDevice smartDev1 = new SmartDevice();
        assertFalse(smartDev1.getOn());
        smartDev1 = new SmartDevice("b1", false);
        assertFalse(smartDev1.getOn());
        smartDev1 = new SmartDevice("b1", true);
        assertTrue(smartDev1.getOn());
    }

    @Test
    public void testSetOn() {
        SmartDevice smartDev1 = new SmartDevice("b1", false);
        smartDev1.setOn(true);
        assertTrue(smartDev1.getOn());
        smartDev1.setOn(false);
        assertFalse(smartDev1.getOn());
    }
}
