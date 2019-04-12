/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao.scripts;

import controller.Log;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import models.dao.OperacoesBancoDeDadosDAO;

/**
 *
 * @author luizfritsch
 */
public class PopulaProfissoes {

    private Log log;

    public static void main(String[] args) {
        PopulaProfissoes p = new PopulaProfissoes();
    }

    public PopulaProfissoes() {
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
            log.EscreveNoLog(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
