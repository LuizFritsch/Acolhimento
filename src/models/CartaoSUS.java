/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.Log;
import java.math.BigInteger;
import javax.swing.JOptionPane;

/**
 *
 * @author MarcoAntonio
 */
public class CartaoSUS {

    private String numeroCartaoSUS;
    private String consultaGeralSaudeCGS;
    private Log log;

    public CartaoSUS() {

    }

    public CartaoSUS(String nmrCartaoSUS, String CGS) {
        log = new Log();
        try {
            if (contemCharacter(nmrCartaoSUS)) {
                throw new Exception("O cartão contem caracteres não númericos");
            }
            this.numeroCartaoSUS = nmrCartaoSUS;
        } catch (Exception erro) {
            log.EscreveNoLog(erro.getMessage());
            JOptionPane.showMessageDialog(null, "Erro:" + erro.getMessage());
        }
        try {
            this.consultaGeralSaudeCGS = CGS;
        } catch (Exception erro) {
            log.EscreveNoLog(erro.getMessage());
            JOptionPane.showMessageDialog(null, "O CGS está incorreto, tente novamente!");
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

    public final boolean contemCharacter(String nmrCartao) {
        boolean contemDigito = false;

        if (nmrCartao != null && !nmrCartao.isEmpty()) {
            for (char c : nmrCartao.toCharArray()) {
                if (contemDigito = Character.isDigit(c)) {
                    break;
                }
            }
        }
        return contemDigito;
    }

    @Override
    public String toString() {
        return "CartaoSUS{" + "numeroCartaoSUS=" + numeroCartaoSUS + ", consultaGeralSaudeCGS=" + consultaGeralSaudeCGS + '}';
    }
}
