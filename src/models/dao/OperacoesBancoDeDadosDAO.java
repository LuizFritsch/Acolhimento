/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;

import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author luizfritsch
 */
public class OperacoesBancoDeDadosDAO {

    private ConexaoBancoDeDadosDAO conexaoDao;

    public OperacoesBancoDeDadosDAO() throws SQLException, ClassNotFoundException {
        this.conexaoDao = ConexaoBancoDeDadosDAO.getInstance();
    }

    public ResultSet selectTodasProfissoes() throws SQLException, Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT *");
        sql.append("FROM profissoes");
        PreparedStatement comando = this.conexaoDao.pegarConexao().prepareStatement(sql.toString());
        ResultSet resultado = comando.executeQuery();
        return resultado;
    }

}
