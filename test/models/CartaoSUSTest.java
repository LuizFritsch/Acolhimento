/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import exceptions.CartaoSUSExceptions;
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

    public CartaoSUSExceptions csNmr;
    public CartaoSUSExceptions csCGS;

    public CartaoSUSTest() {
        csNmr = new CartaoSUSExceptions("O cartão SUS está incorreto: contém caracteres não númericos");
        csCGS = new CartaoSUSExceptions("O CGS está incorreto: contém caracteres não númericos");
    }

    /**
     * Test of getNumeroCartaoSUS method, of class CartaoSUS. utilizando valor
     * real de cartao sus
     */
    @Test
    public void test1GetNumeroCartaoSUS() {
        String numeroCartaoSUS = "898000085774482";
        CartaoSUS instance = new CartaoSUS();
        instance.setNumeroCartaoSUS(numeroCartaoSUS);
        assertTrue(instance.getNumeroCartaoSUS().equals("898000085774482"));
    }

    /**
     * Test of setNumeroCartaoSUS method, of class CartaoSUS. Utilizando valor
     * real de cartao sus
     */
    @Test
    public void test2SetNumeroCartaoSUSComValorValidoReal() {
        String numeroCartaoSUS = "898000085774482";
        CartaoSUS instance = new CartaoSUS();
        instance.setNumeroCartaoSUS(numeroCartaoSUS);
        assertTrue(instance.getNumeroCartaoSUS().equals("898000085774482"));
    }

    /**
     * Test of construtor usando parametros nmr cartao sus e cgs incorreto.
     * Utilizando caracter nao numerico
     */
    @Test
    public void test3() {
        try {
            CartaoSUS instance = new CartaoSUS("ABCVC", "AS");
        } catch (Exception e) {
            assertEquals(csNmr.getMessage(), e.getMessage());
        }
    }

    /**
     * Test of construtor usando parametro CGS incorreto. Utilizando caracter
     * nao numerico
     */
    @Test
    public void test4() {
        try {
            CartaoSUS instance = new CartaoSUS("123", "AS");
        } catch (Exception e) {
            assertEquals(csCGS.getMessage(), e.getMessage());
        }
    }

    /**
     * Test of construtor usando parametro nmr cartao sus incorreto. Utilizando
     * caracter nao numerico
     */
    @Test
    public void test5() {
        try {
            CartaoSUS instance = new CartaoSUS("AS", "123");
        } catch (Exception e) {
            assertEquals(csNmr.getMessage(), e.getMessage());
        }
    }

}
