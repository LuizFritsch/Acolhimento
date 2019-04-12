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
import models.CartaoSUS;
import models.Paciente;
import models.Residencia;

/**
 *
 * @author luizfritsch
 */
public class OperacoesBancoDeDadosDAO {

    private ConexaoBancoDeDadosDAO conexaoDao;
    private final String INSERTPROFISSOES = "INSERT INTO profissao(codigo, cbo, nome) VALUES (?, ?,?)";
    private final String INSERTCARTAOSUS = "INSERT INTO cartaosus(numero, cgs) VALUES (?,?)";
    private final String INSERTRESIDENCIA = "INSERT INTO residencia(codigo, rua, numero, bairro, cidade) VALUES (?,?,?,?,?)";
    private final String INSERTPACIENTE = "INSERT INTO paciente(codigo, nome, cpf, naturalidade, nomemae, cartaosus_codigo, residencia_codigo, profissao_codigo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    //private final String UPDATE = "UPDATE CONTATO SET NOME=?, TELEFONE=?, EMAIL=? WHERE ID=?";
    private final String DELETE = "DELETE FROM profissoes WHERE ID =?";
    //private final String LIST = "SELECT * FROM CONTATO";
    //private final String LISTBYID = "SELECT * FROM CONTATO WHERE ID=?";
    private final String SELECTCARTAOSUS = "SELECT * FROM cartaosus WHERE numero = ?";

    public OperacoesBancoDeDadosDAO() throws SQLException, ClassNotFoundException {
        this.conexaoDao = ConexaoBancoDeDadosDAO.getInstance();
    }

    public void insertProfissoes(String cbo, String nome) throws SQLException {
        PreparedStatement comando = this.conexaoDao.pegarConexao().prepareStatement(INSERTPROFISSOES);

        comando.setString(1, null);
        comando.setString(2, cbo);
        comando.setString(3, nome);

        comando.execute();
    }

    public ResultSet selectTodasProfissoes() throws SQLException, Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT *");
        sql.append("FROM profissoes");
        PreparedStatement comando = this.conexaoDao.pegarConexao().prepareStatement(sql.toString());
        ResultSet resultado = comando.executeQuery();
        return resultado;
    }

    public void insertCartaoSUS(CartaoSUS cartaosus) throws SQLException {
        PreparedStatement comando = this.conexaoDao.pegarConexao().prepareStatement(INSERTCARTAOSUS);

        comando.setString(1, cartaosus.getNumeroCartaoSUS());
        comando.setString(2, cartaosus.getConsultaGeralSaudeCGS());

        comando.execute();
    }

    public void insertResidencia(Residencia residencia) throws SQLException {
        PreparedStatement comando = this.conexaoDao.pegarConexao().prepareStatement(INSERTRESIDENCIA);

        comando.setString(1, null);
        comando.setString(2, residencia.getRua());
        comando.setString(3, residencia.getNumero());
        comando.setString(4, residencia.getBairro());
        comando.setString(5, residencia.getCidade());

        comando.execute();
    }

    public String selectCodigoCartaoSUSPeloNumero(CartaoSUS cartaosus) throws SQLException {

        PreparedStatement comando = this.conexaoDao.pegarConexao().prepareStatement(SELECTCARTAOSUS);

        comando.setString(1, cartaosus.getNumeroCartaoSUS());
        
        ResultSet r = comando.executeQuery();

        r.next();
        
        return r.getString("codigo");
    }

    public void insertPaciente(Paciente paciente) throws SQLException, Exception {
        insertCartaoSUS(paciente.getCartaoSUS());
        insertResidencia(paciente.getResidencia());

        PreparedStatement comando = this.conexaoDao.pegarConexao().prepareStatement(INSERTPACIENTE);
        //codigo, nome, cpf, naturalidade, nomemae, cartaosus_codigo, residencia_codigo, profissao_codigo
        comando.setString(1, null);
        comando.setString(2, paciente.getNomePaciente());
        comando.setString(3, paciente.getCPF());
        comando.setString(4, paciente.getNaturalidade());
        comando.setString(5, paciente.getNomeMae());
        comando.setString(6, selectCodigoCartaoSUSPeloNumero(paciente.getCartaoSUS()));
        comando.setString(7, paciente.getDataNascimento().toString());
        comando.setString(8, paciente.getDataNascimento().toString());

        comando.execute();
    }
}
