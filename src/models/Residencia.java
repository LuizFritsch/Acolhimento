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
public class Residencia {

    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private Log log;
    
    public Residencia(String rua, String numero, String bairro, String cidade) {
        try {
            this.rua = rua;
            this.numero = numero;
            this.bairro = bairro;
            this.cidade = cidade;
        } catch (Exception erro) {
            log = new Log();
            log.EscreveNoLog(erro.getMessage());
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Residencia{" + "rua=" + rua + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade + '}';
    }

}
