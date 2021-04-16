/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package container;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        assertTrue(num_Packages_To_Test > 0, "Test case error, you must test at least 1 Package");
        // We create the Packages that we need.
        b = new Package[num_Packages_To_Test];
        for (int i = 0; i < num_Packages_To_Test; i++) {
            b[i] = new Package((i + 1) * package_Unit_Volume);
        }
        // Now, we create the Container
        container = new Container();
    }

    @AfterEach
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
            assertTrue(container.add(b[i]), "container.add(Package) failed to add a new Package");
            assertFalse(container.add(b[i]), "container.add(Package) seems to allow the same Package to be added twice");
            assertTrue(container.contains(b[i]), "container does not contain a Package after it is supposed to have been added");
        }
    }

    /**
     * Test of remove method, of class Container.
     */
    @Test
    public void testRemove() {
        container.clear();
        assertFalse(container.remove(b[0]), "container.remove(Package) should fail because Container is empty, but it didn't");
        for (int i = 0; i < num_Packages_To_Test; i++) {
            container.clear();
            for (int j = 0; j < i; j++) {
                container.add(b[j]);
            }
            for (int j = 0; j < i; j++) {
                assertTrue(container.remove(b[j]), "container.remove(Package) failed to remove a Package that is supposed to be inside");
                assertFalse(container.contains(b[j]), "container still contains a Package after it is supposed to have been removed !");
            }
            for (int j = i; j < num_Packages_To_Test; j++) {
                assertFalse(container.remove(b[j]), "container.remove(Package) did not fail for a Package that is not inside");
            }
        }
    }

    /**
     * Test of getVolume method, of class Container.
     */
    @Test
    public void testGetVolume() {
        System.out.println("getVolume");
        Container instance = new Container();
        double expResult = 0.0;
        double result = instance.getVolume();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class Container.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        Container instance = new Container();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class Container.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        Container instance = new Container();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class Container.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Package b = null;
        Container instance = new Container();
        boolean expResult = false;
        boolean result = instance.contains(b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
