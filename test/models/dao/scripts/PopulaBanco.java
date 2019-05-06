/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao.scripts;

import controller.Log;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import models.dao.OperacoesBancoDeDadosDAO;

/**
 *
 * @author luizfritsch
 */
public class PopulaBanco {

    private Log log;

    public static void main(String[] args) {
        PopulaBanco p = new PopulaBanco();

    }

    /**
     * Método para popular a tabela relacao_trabalho, que é um *:1 com
     * informacoes_profissionais
     *
     * Fica mais facil de visualizar assim. Quando precisar add alguma relacao
     * de trabalho ou modificar, só será necessário alterar aqui.
     */
    public void popula_relacao_trabalho() {
        try {
            //Fica mais facil de visualizar assim.
            //Quando precisar add alguma relacao de trabalho ou modificar,
            //só será necessário alterar aqui.
            ArrayList<String> listaRelacaoTrabalho = new ArrayList<>();
            listaRelacaoTrabalho.add("Assalariado");
            listaRelacaoTrabalho.add("Desempregado");
            listaRelacaoTrabalho.add("Aposentado");
            listaRelacaoTrabalho.add("Empregado");
            listaRelacaoTrabalho.add("Autônomo");
            listaRelacaoTrabalho.add("Mercado Informal");
            insert_generico("relacao_trabalho", listaRelacaoTrabalho);
        } catch (Exception e) {
            log = new Log();
            log.EscreveNoLog("Erro ao popular a tabela relacao_trabalho: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao popular a tagbela relacao_trabalho: " + e.getMessage());
        }
    }

    /**
     * Método para popular a tabela situacao_trabalho, que é um *:1 com
     * informacoes_profissionais
     *
     * Fica mais facil de visualizar assim. Quando precisar add alguma situacao
     * de trabalho ou modificar, só será necessário alterar aqui.
     */
    public void popula_situacao_trabalho() {
        try {
            //Fica mais facil de visualizar assim.
            //Quando precisar add alguma relacao de trabalho ou modificar,
            //só será necessário alterar aqui.
            ArrayList<String> listaSituacaoTrabalho = new ArrayList<>();
            listaSituacaoTrabalho.add("Ativo na mesma ocupação");
            listaSituacaoTrabalho.add("Empregado");
            listaSituacaoTrabalho.add("Afastado");
            listaSituacaoTrabalho.add("Autonomo");
            listaSituacaoTrabalho.add("Aposentado");
            listaSituacaoTrabalho.add("Mercado Informal");

            insert_generico("situacao_trabalho", listaSituacaoTrabalho);
        } catch (Exception e) {
            log = new Log();
            log.EscreveNoLog("Erro ao popular a tabela situacao_trabalho: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao popular a tabela situacao_trabalho: " + e.getMessage());
        }
    }

    /**
     * Método para popular a tabela profissoes, que é um *:1 com
     * informacoes_profissionais
     */
    public void popula_profissoes() {
        try {
            OperacoesBancoDeDadosDAO opdao = new OperacoesBancoDeDadosDAO();
            String arquivoCSV = System.getProperty("user.dir") + "/test/models/dao/scripts/cbo-profissoes.csv";

            String linha = "";
            String csvDivisor = ";";
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arquivoCSV), "ISO-8859-1"));

            while ((linha = br.readLine()) != null) {
                String[] profissao = linha.split(csvDivisor);
                String cbo = profissao[0];
                String nome = profissao[1];
                opdao.insertProfissoes(cbo, nome);
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            log = new Log();
            log.EscreveNoLog("Erro ao popular a tabela profissao: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao popular a tabela profissao: " + e.getMessage());
        }
    }

    public void insert_generico(String nome_tabela, ArrayList<String> listaDados) {
        try {
            OperacoesBancoDeDadosDAO opdao = new OperacoesBancoDeDadosDAO();
            for (String dado : listaDados) {
                opdao.insert_generico(nome_tabela, dado);
            }
        } catch (SQLException | ClassNotFoundException e) {
            log = new Log();
            log.EscreveNoLog("Erro ao inserir genericamente: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao popular a tabela  " + nome_tabela + ", no insert generico: " + e.getMessage());
        }
    }

    /**
     * Método para popular a tabela carteira_trabalho, que é um *:1 com
     * informacoes_profissionais
     */
    public void popula_carteira_trabalho() {
        try {
            //Fica mais facil de visualizar assim.
            //Quando precisar add alguma relacao de trabalho ou modificar,
            //só será necessário alterar aqui.
            ArrayList<String> listacarteiraTrabalho = new ArrayList<>();
            listacarteiraTrabalho.add("Assalariado com carteira");
            listacarteiraTrabalho.add("Assalariado com dispensa de assinatura da carteira pelo RJU");
            listacarteiraTrabalho.add("Não assalariado");
            listacarteiraTrabalho.add("Assalariado sem carteira assinada");
            listacarteiraTrabalho.add("Não se aplica");

            insert_generico("carteira_trabalho", listacarteiraTrabalho);
        } catch (Exception e) {
            log = new Log();
            log.EscreveNoLog("Erro ao popular a tabela carteira_trabalho: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao popular a tabela carteira_trabalho: " + e.getMessage());
        }
    }

    public PopulaBanco() {
        System.out.println("Qual voce deseja executar?");
        System.out.println("1. Popular todas tabelas");
        System.out.println("2. Popular tabela profissoes");
        System.out.println("3. Popular tabela relacao_trabalho");
        System.out.println("4. Popular tabela situacao_trabalho");
        System.out.println("5. Popular tabela carteira_trabalho");
        System.out.println("6. Popular tabela escolaridade");
        System.out.println("7. Popular tabela beneficios_previdenciarios");
        System.out.println("8. Popular tabela objetivo_consulta");
        Scanner input = new Scanner(System.in);
        String escolha = input.next();
        input.close();
        switch (escolha) {
            case "1":
                System.out.println("populando todas tabelas...");
                System.out.println("populando a tabela profissoes...");
                popula_profissoes();
                System.out.println("populando a tabela relacao_trabalho...");
                popula_relacao_trabalho();
                System.out.println("populando a tabela situacao_trabalho...");
                popula_situacao_trabalho();
                System.out.println("populando a tabela carteira_trabalho...");
                popula_carteira_trabalho();
                System.out.println("populando a tabela carteira_trabalho...");
                popula_carteira_trabalho();
                System.out.println("populando a tabela escolaridade...");
                popula_escolaridade();
                System.out.println("populando a tabela beneficios_previdenciarios...");
                popula_beneficios_previdenciarios();
                System.out.println("populando a tabela objetivo_consulta...");
                popula_objetivo_consulta();
                System.out.println("Feito...");
                break;
            case "2":
                System.out.println("populando a tabela profissoes...");
                popula_profissoes();
                System.out.println("Feito...");
                break;
            case "3":
                System.out.println("populando a tabela relacao_trabalho...");
                popula_relacao_trabalho();
                System.out.println("Feito...");
                break;
            case "4":
                System.out.println("populando a tabela situacao_trabalho...");
                popula_situacao_trabalho();
                System.out.println("Feito...");
                break;
            case "5":
                System.out.println("populando a tabela carteira_trabalho...");
                popula_carteira_trabalho();
                System.out.println("Feito...");
                break;
            case "6":
                System.out.println("populando a tabela escolaridade...");
                popula_escolaridade();
                System.out.println("Feito...");
                break;
            case "7":
                System.out.println("populando a tabela beneficios_previdenciarios...");
                popula_beneficios_previdenciarios();
                System.out.println("Feito...");
                break;
            case "8":
                System.out.println("populando a tabela objetivo_consulta...");
                popula_objetivo_consulta();
                System.out.println("Feito...");
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    private void popula_escolaridade() {
        try {
            //Fica mais facil de visualizar assim.
            //Quando precisar add alguma relacao de trabalho ou modificar,
            //só será necessário alterar aqui.
            ArrayList<String> listaEscolaridade = new ArrayList<>();
            listaEscolaridade.add("Não sabe ler/Escrever");
            listaEscolaridade.add("1o Grau incompleto");
            listaEscolaridade.add("2º Grau incompleto");
            listaEscolaridade.add("Superior Incompleto");
            listaEscolaridade.add("Especialização/Residencia");
            listaEscolaridade.add("1o Grau Completo");
            listaEscolaridade.add("2º Grau completo");
            listaEscolaridade.add("Superior completo");
            listaEscolaridade.add("Mestrado");
            listaEscolaridade.add("Doutorado");

            insert_generico("escolaridade", listaEscolaridade);
        } catch (Exception e) {
            log = new Log();
            log.EscreveNoLog("Erro ao popular a tabela escolaridade: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao popular a tabela escolaridade: " + e.getMessage());
        }

    }

    private void popula_beneficios_previdenciarios() {
        try {
            //Fica mais facil de visualizar assim.
            //Quando precisar add alguma relacao de trabalho ou modificar,
            //só será necessário alterar aqui.
            ArrayList<String> listaBeneficiosPrevidenciarios = new ArrayList<>();
            listaBeneficiosPrevidenciarios.add("Não recebe aposentadoria");
            listaBeneficiosPrevidenciarios.add("Auxílio acidente");
            listaBeneficiosPrevidenciarios.add("Aposentadoria Previdenciária");
            listaBeneficiosPrevidenciarios.add("Aposentadoria tempo de serviço");
            listaBeneficiosPrevidenciarios.add("idade ou especial");
            listaBeneficiosPrevidenciarios.add("Não se aplica");
            listaBeneficiosPrevidenciarios.add("Não sabe informar");

            insert_generico("beneficios_previdenciarios", listaBeneficiosPrevidenciarios);
        } catch (Exception e) {
            log = new Log();
            log.EscreveNoLog("Erro ao popular a tabela beneficios_previdenciarios: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao popular a tabela beneficios_previdenciarios: " + e.getMessage());
        }
    }

    private void popula_objetivo_consulta() {
        try {
            //Fica mais facil de visualizar assim.
            //Quando precisar add alguma relacao de trabalho ou modificar,
            //só será necessário alterar aqui.
            ArrayList<String> listaObjetivoConsulta = new ArrayList<>();
            listaObjetivoConsulta.add("Esclarecimento diagnóstico");
            listaObjetivoConsulta.add("Tratamento");
            listaObjetivoConsulta.add("Outro");
            insert_generico("objetivo_consulta", listaObjetivoConsulta);
        } catch (Exception e) {
            log = new Log();
            log.EscreveNoLog("Erro ao popular a tabela objetivo_consulta: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao popular a tabela objetivo_consulta: " + e.getMessage());
        }
    }

}
