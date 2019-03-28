/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import views.FramePrincipal;

/**
 *
 * @author LuizFritsch
 */
public class AcolhimentoController {

    private Log log;

    public AcolhimentoController() {

        try {
            FramePrincipal fp = new FramePrincipal();
            fp.setVisible(true);
        } catch (Exception erro) {
            log = new Log();
            log.EscreveNoLog(erro.getMessage());
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }

    }

}
