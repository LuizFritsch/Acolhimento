/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;

import controller.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author luizfritsch
 */
public class ConexaoBancoDeDadosDAO {

    private static final String USUARIO = "cerest";
    private static final String SENHA = "302050027";
    private static final String URL = "jdbc:mysql://192.168.7.41:3306/Acolhimento";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    // Conectar ao banco
    public static Connection abrir() throws Exception {
        // Registrar o driver
        Class.forName(DRIVER);
        // Capturar a conexão
        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);

        System.out.println("OI");

        // Retorna a conexao aberta
        return conn;

    }

}
