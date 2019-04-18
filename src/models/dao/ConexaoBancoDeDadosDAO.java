/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;

import controller.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author luizfritsch
 */
public class ConexaoBancoDeDadosDAO {

    private static ConexaoBancoDeDadosDAO instance;
    private Connection conexao;
    private static final String USUARIO = "cerest";
    private static final String SENHA = "302050027";
    private static final String URL = "jdbc:mysql://192.168.7.41:3306/acolhimento";
    private Log log;

    /**
     * Conexao singleton
     *
     * @throws SQLException
     */
    private ConexaoBancoDeDadosDAO() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        this.conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    public Connection pegarConexao() {
        return conexao;
    }

    public static ConexaoBancoDeDadosDAO getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null) {
            instance = new ConexaoBancoDeDadosDAO();
        } else if (instance.pegarConexao().isClosed()) {
            instance = new ConexaoBancoDeDadosDAO();
        }
        return instance;
    }

    public void fecharConexao() throws Exception {
        this.conexao.close();
    }
}
