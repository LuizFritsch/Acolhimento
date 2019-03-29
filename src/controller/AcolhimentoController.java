/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import views.FramePrincipal;

/**
 *
 * @author LuizFritsch
 */
public class AcolhimentoController {

    private Log log;
    private static FramePrincipal fp;

    public AcolhimentoController() {
        try {
            fp = singletonGetInstanceOfFramePrincipal();
            fp.setVisible(true);
        } catch (Exception erro) {
            log = new Log();
            log.EscreveNoLog(erro.getMessage());
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }

    public void salvar(ArrayList<String> infoPaciente) {
        try {
            for (String string : infoPaciente) {
                System.out.println(string);
            }
        } catch (Exception erro) {
            log.EscreveNoLog(erro.getMessage());
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }

    }

    public synchronized static FramePrincipal singletonGetInstanceOfFramePrincipal() {
        if (fp == null) {
            fp = new FramePrincipal();
        }
        return fp;

    }

}
