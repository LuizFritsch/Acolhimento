/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author luizfritsch
 */
public class OperacoesBancoDeDadosDAOTest {

    public OperacoesBancoDeDadosDAOTest() {
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
     * Test of selectTodasProfissoes method, of class OperacoesBancoDeDadosDAO.
     */
    @Test
    public void testSelectTodasProfissoes() throws Exception {

    }
    
    @Test
    public void test2() throws SQLException, ClassNotFoundException{
        OperacoesBancoDeDadosDAO op = new OperacoesBancoDeDadosDAO();
        op.insertProfissoes("TESTE", "123");
    }

}
