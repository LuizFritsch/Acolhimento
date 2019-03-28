/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.Log;
import controller.Utils;
import exceptions.CartaoSUSExceptions;
import javax.swing.JOptionPane;

/**
 *
 * @author LuizFritsch
 */
public class CartaoSUS {

    private String numeroCartaoSUS;
    private String consultaGeralSaudeCGS;
    private Log log;
    private Utils utilidades;
    private CartaoSUSExceptions cs;

    public CartaoSUS(String nmrCartaoSUS, String CGS) throws CartaoSUSExceptions {
        log = new Log();
        utilidades = new Utils();

        if (utilidades.naoContemCaracterNaoNumerico(nmrCartaoSUS)) {
            this.numeroCartaoSUS = nmrCartaoSUS;
            if (utilidades.naoContemCaracterNaoNumerico(CGS)) {
                this.consultaGeralSaudeCGS = CGS;
            } else {
                cs = new CartaoSUSExceptions("O CGS está incorreto: contém caracteres não númericos");
                log.EscreveNoLog(cs.getMessage());
                JOptionPane.showMessageDialog(null, "Erro: " + cs.getMessage());
                throw cs;
            }
        } else {
            cs = new CartaoSUSExceptions("O cartão SUS está incorreto: contém caracteres não númericos");
            log.EscreveNoLog(cs.getMessage());
            JOptionPane.showMessageDialog(null, "Erro: " + cs.getMessage());
            throw cs;
        }

    }

    public String getNumeroCartaoSUS() {
        return numeroCartaoSUS;
    }

    public void setNumeroCartaoSUS(String numeroCartaoSUS) {
        this.numeroCartaoSUS = numeroCartaoSUS;
    }

    public String getConsultaGeralSaudeCGS() {
        return consultaGeralSaudeCGS;
    }

    public void setConsultaGeralSaudeCGS(String consultaGeralSaudeCGS) {
        this.consultaGeralSaudeCGS = consultaGeralSaudeCGS;
    }

    @Override
    public String toString() {
        return "CartaoSUS{" + "numeroCartaoSUS=" + numeroCartaoSUS + ", consultaGeralSaudeCGS=" + consultaGeralSaudeCGS + '}';
    }

}
