/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao.scripts;

import controller.Log;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
            BufferedReader br = null;
            String linha = "";
            String csvDivisor = ";";

            br = new BufferedReader(new FileReader(arquivoCSV));
            while ((linha = br.readLine()) != null) {
                String[] profissao = linha.split(csvDivisor);
                opdao.insertProfissoes(profissao[0], profissao[1]);
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            log = new Log();
            log.EscreveNoLog(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
