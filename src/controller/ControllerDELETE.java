/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.dao.OperacoesBancoDeDadosDAO;

/**
 *
 * @author luizfritsch
 */
public class ControllerDELETE {

    private OperacoesBancoDeDadosDAO op;
    private Log log;

    public ControllerDELETE() {
        try {
            op = new OperacoesBancoDeDadosDAO();
        } catch (SQLException | ClassNotFoundException erro) {
            log = new Log();
            log.EscreveNoLog(erro.getMessage());
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
        }
    }

    public void deleteTudo() {
        try {
            op.deleteTudo();
        } catch (Exception erro) {
            log.EscreveNoLog(erro.getMessage());
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
        }
    }

    public void deletePorTabela(ArrayList<String> listaTabela) {
        try {
            op.delete(listaTabela);
        } catch (Exception erro) {
            log.EscreveNoLog(erro.getMessage());
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
        }
    }

}
