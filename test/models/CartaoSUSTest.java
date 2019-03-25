/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author MarcoAntonio
 */
public class CartaoSUSTest {

    public CartaoSUSTest() {
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
     * Test of getNumeroCartaoSUS method, of class CartaoSUS.
     */
    @Test
    public void testGetNumeroCartaoSUS() {
        String numeroCartaoSUS = "898000085774482";
        CartaoSUS instance = new CartaoSUS();
        instance.setNumeroCartaoSUS(numeroCartaoSUS);
        assertTrue(instance.getNumeroCartaoSUS().equals("898000085774482"));
    }

    /**
     * Test of setNumeroCartaoSUS method, of class CartaoSUS.
     */
    @Test
    public void testSetNumeroCartaoSUS() {
        String numeroCartaoSUS = "898000085774482";
        CartaoSUS instance = new CartaoSUS();
        instance.setNumeroCartaoSUS(numeroCartaoSUS);
        assertTrue(instance.getNumeroCartaoSUS().equals("898000085774482"));
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testSetNumeroCartaoSUSComParametroIncorreto() {
        exception.expect(Exception.class);
        CartaoSUS instance = new CartaoSUS("ABCVC", "AS");
    }

    /**
     * Test of getConsultaGeralSaudeCGS method, of class CartaoSUS.
     */
    @Test
    public void testGetConsultaGeralSaudeCGS() {

    }

    /**
     * Test of setConsultaGeralSaudeCGS method, of class CartaoSUS.
     */
    @Test
    public void testSetConsultaGeralSaudeCGS() {

    }

    /**
     * Test of toString method, of class CartaoSUS.
     */
    @Test
    public void testToString() {

    }

}
