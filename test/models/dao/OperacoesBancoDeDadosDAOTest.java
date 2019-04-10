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
    public void test2() throws SQLException, ClassNotFoundException {
        OperacoesBancoDeDadosDAO op = new OperacoesBancoDeDadosDAO();
        op.insertProfissoes("TESTE", "123");
    }

    @Test
    public void test3() throws SQLException, ClassNotFoundException, CartaoSUSExceptions {
        OperacoesBancoDeDadosDAO op = new OperacoesBancoDeDadosDAO();
        CartaoSUS cartaosus = new CartaoSUS("465465", "4565465460");
        //assertinsertCartaoSUS(cartaosus)
    }

    @Test
    public void test4() throws SQLException, ClassNotFoundException, CartaoSUSExceptions, Exception {
        OperacoesBancoDeDadosDAO op = new OperacoesBancoDeDadosDAO();
        CartaoSUS cartaosus = new CartaoSUS("909067867879090", "90945430");
        Residencia residencia = new Residencia("", "", "", "");
        Profissao profissao = new Profissao("");
        Date data = new Date();
        Paciente paciente = new Paciente("", "", "", "", "", residencia, data, profissao, cartaosus);
        //assertTrue(op.insertPaciente(paciente));
    }

}
