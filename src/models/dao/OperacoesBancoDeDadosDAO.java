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
import models.Profissao;
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
    private final String INSERTPACIENTE = "INSERT INTO paciente(nome, cpf, naturalidade, nomemae, datanascimento, cartaosus_codigo, residencia_codigo, profissao_codigo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    //private final String UPDATE = "UPDATE CONTATO SET NOME=?, TELEFONE=?, EMAIL=? WHERE ID=?";
    private final String DELETE = "DELETE FROM profissoes WHERE ID =?";
    //private final String LIST = "SELECT * FROM CONTATO";
    //private final String LISTBYID = "SELECT * FROM CONTATO WHERE ID=?";
    private final String SELECTCARTAOSUS = "SELECT * FROM cartaosus WHERE numero = ?";
    private final String SELECTRESIDENCIA = "SELECT * FROM residencia WHERE rua = ? AND numero = ?";
    private final String SELECTPROFISSAO = "SELECT * FROM profissao WHERE nome = ?";

    public OperacoesBancoDeDadosDAO() throws SQLException, ClassNotFoundException {
        this.conexaoDao = ConexaoBancoDeDadosDAO.getInstance();
    }

    /**
     * insere uma profissao
     *
     * @param cbo
     * @param nome
     * @throws SQLException
     */
    public void insertProfissoes(String cbo, String nome) throws SQLException {
        PreparedStatement comando = this.conexaoDao.pegarConexao().prepareStatement(INSERTPROFISSOES);

        comando.setString(1, null);
        comando.setString(2, cbo);
        comando.setString(3, nome);

        comando.execute();
    }

    /**
     * retorna um resultset contendo a lista das profissoes e os seus
     * respectivos cbos
     *
     * @return @throws SQLException
     * @throws Exception
     */
    public ResultSet selectTodasProfissoes() throws SQLException, Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT *");
        sql.append("FROM profissao");
        PreparedStatement comando = this.conexaoDao.pegarConexao().prepareStatement(sql.toString());
        ResultSet resultado = comando.executeQuery();
        return resultado;
    }

    /**
     * insere um cartaosus
     *
     * @param cartaosus
     * @throws SQLException
     */
    public void insertCartaoSUS(CartaoSUS cartaosus) throws SQLException {
        PreparedStatement comando = this.conexaoDao.pegarConexao().prepareStatement(INSERTCARTAOSUS);

        comando.setString(1, cartaosus.getNumeroCartaoSUS());
        comando.setString(2, cartaosus.getConsultaGeralSaudeCGS());

        comando.execute();
    }

    /**
     * Insere uma residencia
     *
     * @param residencia
     * @throws SQLException
     */
    public void insertResidencia(Residencia residencia) throws SQLException {
        PreparedStatement comando = this.conexaoDao.pegarConexao().prepareStatement(INSERTRESIDENCIA);

        comando.setString(1, null);
        comando.setString(2, residencia.getRua());
        comando.setString(3, residencia.getNumero());
        comando.setString(4, residencia.getBairro());
        comando.setString(5, residencia.getCidade());

        comando.execute();
    }

    /**
     * Retprma o codigo do cartaosus
     *
     * @param cartaosus
     * @return
     * @throws SQLException
     */
    public String selectCodigoCartaoSUSPeloNumero(CartaoSUS cartaosus) throws SQLException {

        PreparedStatement comando = this.conexaoDao.pegarConexao().prepareStatement(SELECTCARTAOSUS);

        comando.setString(1, cartaosus.getNumeroCartaoSUS());

        ResultSet r = comando.executeQuery();

        r.next();

        return r.getString("codigo");
    }

    /**
     * Retorna o codigo da residancia
     *
     * @param residencia
     * @return
     * @throws SQLException
     */
    public String selectResidencia(Residencia residencia) throws SQLException {

        ResultSet r;
        try (PreparedStatement comando = this.conexaoDao.pegarConexao().prepareStatement(SELECTRESIDENCIA)) {
            comando.setString(1, residencia.getRua());
            comando.setString(2, residencia.getNumero());
            r = comando.executeQuery();
            r.next();
        }
        return r.getString("codigo");
    }

    /**
     * Retorna o codigo da profissao
     *
     * @param profissao
     * @return
     * @throws SQLException
     */
    public String selectProfissao(Profissao profissao) throws SQLException {

        ResultSet r;
        try (PreparedStatement comando = this.conexaoDao.pegarConexao().prepareStatement(SELECTPROFISSAO)) {
            comando.setString(1, profissao.getNomeProfissao());
            r = comando.executeQuery();
            r.next();
        }
        return r.getString("codigo");
    }

    /**
     *
     * @param paciente
     * @throws SQLException
     */
    public void insertPaciente(Paciente paciente) throws SQLException {
        insertCartaoSUS(paciente.getCartaoSUS());
        insertResidencia(paciente.getResidencia());

        PreparedStatement comando = this.conexaoDao.pegarConexao().prepareStatement(INSERTPACIENTE);
        /**
         * private final String INSERTPACIENTE = "INSERT INTO paciente(nome,
         * cpf, naturalidade, nomemae, datanascimento, cartaosus_codigo,
         * residencia_codigo, profissao_codigo) VALUES (?, ?, ?, ?, ?, ?, ?,
         * ?)";
         */
        try {
            
            comando.setString(1, paciente.getNomePaciente());
            comando.setString(2, paciente.getCPF());
            comando.setString(3, paciente.getNaturalidade());
            comando.setString(4, paciente.getNomeMae());
            comando.setString(5, paciente.getDataNascimento().toString());
            comando.setString(6, selectCodigoCartaoSUSPeloNumero(paciente.getCartaoSUS()));
            System.out.println("erro ao pegar o cartao sus");
            comando.setString(7, selectResidencia(paciente.getResidencia()));
            System.out.println("erro no insert residencia do paciente");
            comando.setString(8, selectProfissao(paciente.getProfissao()));
            System.out.println("erro no insert profissao");
            comando.execute();
            System.out.println("Executou a query");
        } catch (Exception e) {
            System.out.println("errooooooooooooo");
        }
        
    }
}
