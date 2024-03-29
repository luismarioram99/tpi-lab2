/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package container;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author luismarioram99
 */
public class ContainerTest {

    private Container container = null;
    private int num_Packages_To_Test = 5;
    private Package[] b = null;
    private double package_Unit_Volume = 10.0;

    public ContainerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        assertTrue("Test case error, you must test at least 1 Package",
                num_Packages_To_Test > 0);
        // We create the Packages that we need.
        b = new Package[num_Packages_To_Test];
        for (int i = 0; i < num_Packages_To_Test; i++) {
            b[i] = new Package((i + 1) * package_Unit_Volume);
        }
        // Now, we create the Container
        container = new Container();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class Container.
     */
    @Test
    public void testAdd() {
        System.out.println("Add");
        container.clear();
        for (int i = 0; i < num_Packages_To_Test; i++) {
            assertTrue("container.add(Package) failed to add a new Package", container.add(b[i]));
            assertFalse("container.add(Package) seems to allow the same Package to be added twice", container.add(b[i]));
            assertTrue("container does not contain a Package after it is supposed to have been ", container.contains(b[i]));
        }
    }

    /**
     * Test of remove method, of class Container.
     */
    @Test
    public void testRemove() {
        container.clear();
        assertFalse("container.remove(Package) should fail because Container is empty, but it didn't", container.remove(b[0]));
        for (int i = 0; i < num_Packages_To_Test; i++) {
            container.clear();
            for (int j = 0; j < i; j++) {
                container.add(b[j]);
            }
            for (int j = 0; j < i; j++) {
                assertTrue("container.remove(Package) failed to remove a Package that is supposed to be inside", container.remove(b[j]));
                assertFalse("container still contains a Package after it is supposed to have been removed!", container.contains(b[j]));
            }
            for (int j = i; j < num_Packages_To_Test; j++) {
                assertFalse("container.remove(Package) did not fail for a Package that is not inside", container.remove(b[j]));
            }
        }
    }

    /**
     * Test of getVolume method, of class Container.
     */
    @Test
    public void testGetVolume() {
        System.out.println("getVolume");
        double expResult = 0.0;
        double result = 0.0;
        for (int i = 0; i < num_Packages_To_Test; i++) {
            expResult = expResult + b[i].getVolume();
        }
        container.clear();
        for (int i = 0; i < num_Packages_To_Test; i++) {
            container.add(b[i]);
        }
        result = container.getVolume();
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of size method, of class Container.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        container.clear();
        for (int i = 0; i < num_Packages_To_Test; i++) {
            container.add(b[i]);
        }
        int result = container.size();
        assertEquals(num_Packages_To_Test, result);
    }

    /**
     * Test of clear method, of class Container.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        container.clear();
    }

    /**
     * Test of contains method, of class Container.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        container.clear();
        for (int i = 0; i < num_Packages_To_Test; i++) {
            container.add(b[i]);
        }
        for (int i = 0; i < num_Packages_To_Test - 1; i++) {
            assertTrue("container contains a Package", container.contains(b[i]));
        }
    }
}


