/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import javax.swing.JOptionPane;
import models.CartaoSUS;
import models.Paciente;
import models.Profissao;
import models.Residencia;
import models.dao.OperacoesBancoDeDadosDAO;
import views.FramePrincipal;

/**
 *
 * @author LuizFritsch
 */
public class AcolhimentoController {

    private Log log;
    private static FramePrincipal fp;
    private OperacoesBancoDeDadosDAO op;

    public AcolhimentoController() {
        try {
            fp = singletonGetInstanceOfFramePrincipal();
            fp.setVisible(true);
            op = new OperacoesBancoDeDadosDAO();
        } catch (Exception erro) {
            log = new Log();
            log.EscreveNoLog(erro.getMessage());
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }

    public void salvar(HashMap<String, String> infoPaciente) {
        try {
            Date data = new Date(infoPaciente.get("Data de nascimento"));
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            formatter.format(data);
            Set<String> chaves = infoPaciente.keySet();
            Residencia residencia = new Residencia(infoPaciente.get("Endereço"), "", "", "");
            CartaoSUS cartaoSUS = new CartaoSUS(infoPaciente.get("Cartão SUS"), "123");
            Profissao profissao = new Profissao(infoPaciente.get("Profissão"));
            Paciente p = new Paciente(infoPaciente.get("Nome completo"), "codigoPaciente", infoPaciente.get("CPF"), infoPaciente.get("Naturalidade"), infoPaciente.get("Nome da mãe"), residencia, data, profissao, cartaoSUS);
            
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
