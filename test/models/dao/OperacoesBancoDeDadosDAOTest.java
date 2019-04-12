/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;

import exceptions.CartaoSUSExceptions;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import models.CartaoSUS;
import models.Paciente;
import models.Profissao;
import models.Residencia;
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

    OperacoesBancoDeDadosDAO op;

    public OperacoesBancoDeDadosDAOTest() throws SQLException, ClassNotFoundException {
        op = new OperacoesBancoDeDadosDAO();
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

    @Test
    public void test5() throws SQLException, ClassNotFoundException, CartaoSUSExceptions {
        CartaoSUS cartaosus = new CartaoSUS("123456789012345", "1234");
        op.insertCartaoSUS(cartaosus);
        assertEquals("1", op.selectCodigoCartaoSUSPeloNumero(cartaosus));
    }
    
    @Test
    public void test6() throws SQLException, ClassNotFoundException, CartaoSUSExceptions {
        CartaoSUS cartaosus = new CartaoSUS("123456789012346", "1234");
        op.insertCartaoSUS(cartaosus);
        assertEquals("2", op.selectCodigoCartaoSUSPeloNumero(cartaosus));
    }
    
    @Test
    public void test7() throws SQLException, ClassNotFoundException, CartaoSUSExceptions {
        CartaoSUS cartaosus = new CartaoSUS("123456789012347", "1234");
        op.insertCartaoSUS(cartaosus);
        assertEquals("3", op.selectCodigoCartaoSUSPeloNumero(cartaosus));
    }

}
