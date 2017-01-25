/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapping;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mbola
 */
public class JourFerieTest {
    
    public JourFerieTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getID_JOUR_FERIE method, of class JourFerie.
     */
    @Test
    public void testGetID_JOUR_FERIE() {
        System.out.println("getID_JOUR_FERIE");
        JourFerie instance = null;
        long expResult = 0L;
        long result = instance.getID_JOUR_FERIE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setID_JOUR_FERIE method, of class JourFerie.
     */
    @Test
    public void testSetID_JOUR_FERIE() {
        System.out.println("setID_JOUR_FERIE");
        long ID_JOUR_FERIE = 0L;
        JourFerie instance = null;
        instance.setID_JOUR_FERIE(ID_JOUR_FERIE);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMOTIF_JOUR_FERIE method, of class JourFerie.
     */
    @Test
    public void testGetMOTIF_JOUR_FERIE() {
        System.out.println("getMOTIF_JOUR_FERIE");
        JourFerie instance = null;
        String expResult = "";
        String result = instance.getMOTIF_JOUR_FERIE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMOTIF_JOUR_FERIE method, of class JourFerie.
     */
    @Test
    public void testSetMOTIF_JOUR_FERIE() {
        System.out.println("setMOTIF_JOUR_FERIE");
        String MOTIF_JOUR_FERIE = "";
        JourFerie instance = null;
        instance.setMOTIF_JOUR_FERIE(MOTIF_JOUR_FERIE);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDATE_JOUR_FERIE method, of class JourFerie.
     */
    @Test
    public void testGetDATE_JOUR_FERIE() {
        System.out.println("getDATE_JOUR_FERIE");
        JourFerie instance = null;
        String expResult = "";
        String result = instance.getDATE_JOUR_FERIE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDATE_JOUR_FERIE method, of class JourFerie.
     */
    @Test
    public void testSetDATE_JOUR_FERIE() {
        System.out.println("setDATE_JOUR_FERIE");
        String DATE_JOUR_FERIE = "";
        JourFerie instance = null;
        instance.setDATE_JOUR_FERIE(DATE_JOUR_FERIE);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHEURE_DEBUT_JOUR_FERIE method, of class JourFerie.
     */
    @Test
    public void testGetHEURE_DEBUT_JOUR_FERIE() {
        System.out.println("getHEURE_DEBUT_JOUR_FERIE");
        JourFerie instance = null;
        String expResult = "";
        String result = instance.getHEURE_DEBUT_JOUR_FERIE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHEURE_DEBUT_JOUR_FERIE method, of class JourFerie.
     */
    @Test
    public void testSetHEURE_DEBUT_JOUR_FERIE() {
        System.out.println("setHEURE_DEBUT_JOUR_FERIE");
        String HEURE_DEBUT_JOUR_FERIE = "";
        JourFerie instance = null;
        instance.setHEURE_DEBUT_JOUR_FERIE(HEURE_DEBUT_JOUR_FERIE);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHEURE_FIN_JOUR_FERIE method, of class JourFerie.
     */
    @Test
    public void testGetHEURE_FIN_JOUR_FERIE() {
        System.out.println("getHEURE_FIN_JOUR_FERIE");
        JourFerie instance = null;
        String expResult = "";
        String result = instance.getHEURE_FIN_JOUR_FERIE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHEURE_FIN_JOUR_FERIE method, of class JourFerie.
     */
    @Test
    public void testSetHEURE_FIN_JOUR_FERIE() {
        System.out.println("setHEURE_FIN_JOUR_FERIE");
        String HEURE_FIN_JOUR_FERIE = "";
        JourFerie instance = null;
        instance.setHEURE_FIN_JOUR_FERIE(HEURE_FIN_JOUR_FERIE);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdJourFerie method, of class JourFerie.
     */
    @Test
    public void testGetIdJourFerie() throws Exception {
        System.out.println("getIdJourFerie");
        long expResult = 0L;
        long result = JourFerie.getIdJourFerie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListJourFerie method, of class JourFerie.
     */
    @Test
    public void testGetListJourFerie() throws Exception {
        System.out.println("getListJourFerie");
        int annee = 0;
        JourFerie[] expResult = null;
        JourFerie[] result = JourFerie.getListJourFerie(annee);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of andro_fesana method, of class JourFerie.
     */
    @Test
    public void testAndro_fesana() throws Exception {
        System.out.println("andro_fesana");
        String date = "";
        JourFerie expResult = null;
        JourFerie result = JourFerie.andro_fesana(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
