/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.Log;
import javax.swing.JOptionPane;

/**
 *
 * @author luizfritsch
 */
public class Profissao {

    private String nomeProfissao;
    private Log log;

    public Profissao(String nomeProfissao) {
        try {
            this.nomeProfissao = nomeProfissao;
        } catch (Exception erro) {
            log = new Log();
            log.EscreveNoLog("Erro ao criar uma profissão: "+erro.getMessage());
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }

    public String getNomeProfissao() {
        return nomeProfissao;
    }

    public void setNomeProfissao(String nomeProfissao) {
        this.nomeProfissao = nomeProfissao;
    }

    @Override
    public String toString() {
        return "Profissao{" + "nomeProfissao=" + nomeProfissao + '}';
    }

}
