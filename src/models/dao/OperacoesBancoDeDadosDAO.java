/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;

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
    private final String INSERTRELACAOTRABALHO = "INSERT INTO relacao_trabalho(descricao) VALUES (?)";
    private final String INSERTSITUACAOTRABALHO = "INSERT INTO situacao_trabalho(descricao) VALUES (?)";
    private final String INSERTCARTAOSUS = "INSERT INTO cartaosus(numero, cgs) VALUES (?,?)";
    private final String INSERTRESIDENCIA = "INSERT INTO residencia(codigo, rua, numero, bairro, cidade) VALUES (?,?,?,?,?)";
    private final String INSERTPACIENTE = "INSERT INTO paciente(nome, cpf, naturalidade, nomemae, datanascimento, cartaosus_codigo, residencia_codigo, profissao_codigo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private final String DELETE = "DELETE FROM profissoes WHERE ID =?";
    private final String SELECTCARTAOSUS = "SELECT * FROM cartaosus WHERE numero = ?";
    private final String SELECTRESIDENCIA = "SELECT * FROM residencia WHERE rua = ? AND numero = ?";
    private final String SELECTPROFISSAO = "SELECT * FROM profissao WHERE nome = ?";
    private final String SELECTPROFISSAOBYNAME = "SELECT * FROM profissao WHERE nome LIKE ?";
    private final String DELETETUDO = "DELETE FROM paciente, residencia, cartaosus;";

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
     *
     * @param nomeProfissao
     * @return
     * @throws java.sql.SQLException
     */
    public ResultSet selectProfissoesContemString(String nomeProfissao) throws SQLException {
        PreparedStatement comando = this.conexaoDao.pegarConexao().prepareStatement(SELECTPROFISSAOBYNAME);
        comando.setString(1, '%' + nomeProfissao + '%');
        ResultSet resultado = comando.executeQuery();
        return resultado;
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
        PreparedStatement comando = this.conexaoDao.pegarConexao().prepareStatement(SELECTRESIDENCIA);

        comando.setString(1, residencia.getRua());

        comando.setString(2, residencia.getNumero());

        ResultSet r = comando.executeQuery();

        r.next();

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
        PreparedStatement comando = this.conexaoDao.pegarConexao().prepareStatement(SELECTPROFISSAO);

        comando.setString(1, profissao.getNomeProfissao());

        r = comando.executeQuery();

        r.next();

        return r.getString("codigo");
    }

    /**
     * Metodo para limpar o banco
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void deleteTudo() throws SQLException, ClassNotFoundException {
        PreparedStatement comando = this.conexaoDao.pegarConexao().prepareStatement(DELETETUDO);
        comando.executeUpdate();
    }

    public void delete(ArrayList<String> listaDoQueDeletar) throws SQLException, ClassNotFoundException, Exception {
        if (listaDoQueDeletar.isEmpty()) {
            throw new Exception("Erro ao deletar: Lista de tabelas vazias");
        } else {
            for (String nomeTabela : listaDoQueDeletar) {
                PreparedStatement comando = this.conexaoDao.pegarConexao().prepareStatement("DELETE FROM " + nomeTabela + ";");
                comando.executeUpdate();
            }
        }
    }

    /**
     *
     * @param paciente
     * @throws SQLException
     */
    public void insertPaciente(Paciente paciente) throws SQLException, Exception {

        /**
         * private final String INSERTPACIENTE = "INSERT INTO paciente(nome,
         * cpf, naturalidade, nomemae, datanascimento, cartaosus_codigo,
         * residencia_codigo, profissao_codigo) VALUES (?, ?, ?, ?, ?, ?, ?,
         * ?)";
         */
        try {
            PreparedStatement comando = this.conexaoDao.pegarConexao().prepareStatement(INSERTPACIENTE);
            insertCartaoSUS(paciente.getCartaoSUS());
            insertResidencia(paciente.getResidencia());
            comando.setString(1, paciente.getNomePaciente());
            comando.setString(2, paciente.getCPF());
            comando.setString(3, paciente.getNaturalidade());
            comando.setString(4, paciente.getNomeMae());
            comando.setString(5, paciente.getDataNascimento().toString());
            System.out.println(selectCodigoCartaoSUSPeloNumero(paciente.getCartaoSUS()));
            comando.setString(6, selectCodigoCartaoSUSPeloNumero(paciente.getCartaoSUS()));
            System.out.println(selectResidencia(paciente.getResidencia()));
            comando.setString(7, selectResidencia(paciente.getResidencia()));
            System.out.println(selectProfissao(paciente.getProfissao()));
            comando.setString(8, selectProfissao(paciente.getProfissao()));

            comando.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Erro ao inserir um paciente: " + e.getMessage());
        }

    }

    public void insert_relacao_trabalho(String relacao_trabalho) throws SQLException {
        PreparedStatement comando = this.conexaoDao.pegarConexao().prepareStatement(INSERTRELACAOTRABALHO);

        comando.setString(1, relacao_trabalho);

        comando.execute();
    }

    public void insert_situacao_trabalho(String situacao_trabalho) throws SQLException {
        PreparedStatement comando = this.conexaoDao.pegarConexao().prepareStatement(INSERTSITUACAOTRABALHO);

        comando.setString(1, situacao_trabalho);

        comando.execute();
    }

    public void insert_generico(String nome_tabela, String dado) throws SQLException {
        String SQL = "INSERT INTO "+nome_tabela+"(descricao) VALUES (?)";
        PreparedStatement comando = this.conexaoDao.pegarConexao().prepareStatement(SQL);

        comando.setString(1, dado);

        comando.execute();
    }
    
     public ResultSet select_tudo_from_tabela(String nome_da_tabela) throws SQLException, Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT *");
        sql.append("FROM "+nome_da_tabela);
        PreparedStatement comando = this.conexaoDao.pegarConexao().prepareStatement(sql.toString());
        ResultSet resultado = comando.executeQuery();
        return resultado;
    }

}
