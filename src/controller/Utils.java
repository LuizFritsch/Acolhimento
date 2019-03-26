/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author LuizFritsch
 */
public class Utils {

    public Utils() {

    }

    public final boolean naoContemCharacter(String nmrCartao) {
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

}
