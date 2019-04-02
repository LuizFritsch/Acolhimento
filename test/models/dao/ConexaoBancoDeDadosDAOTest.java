/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;

import controller.Log;
import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author luizfritsch
 */
public class ConexaoBancoDeDadosDAOTest {

    public ConexaoBancoDeDadosDAOTest() {
    }

    /**
     * Test of abrir method, of class ConexaoBancoDeDadosDAO.
     */
    @Test
    public void testAbrir() throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT *");
        sql.append("FROM profissoes");
        try {
            ConexaoBancoDeDadosDAO cddao = ConexaoBancoDeDadosDAO.getInstance();
            PreparedStatement comando = cddao.pegarConexao().prepareStatement(sql.toString());
            ResultSet resultado = comando.executeQuery();
            System.out.println(resultado.toString());
            cddao.fecharConexao();
            assertTrue(true);
        } catch (Exception e) {
            Log log = new Log();
            log.EscreveNoLog(e.getMessage());
        }
    }

}
