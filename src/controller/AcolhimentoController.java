/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import exceptions.CartaoSUSExceptions;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
        } catch (SQLException | ClassNotFoundException erro) {
            log = new Log();
            log.EscreveNoLog("Erro no construtor da AcolhimentoController: " +erro.getMessage());
            JOptionPane.showMessageDialog(null, "Erro no construtor da AcolhimentoController: " + erro.getMessage());
        }
    }

    public Paciente criaPaciente(HashMap<String, String> infoPaciente) throws CartaoSUSExceptions {
        Date data = new Date(infoPaciente.get("Data de nascimento"));
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        formatter.format(data);
        //Set<String> chaves = infoPaciente.keySet();
        Residencia residencia = new Residencia(infoPaciente.get("Endereço"), infoPaciente.get("Numero da casa"), "1", "1");
        CartaoSUS cartaoSUS = new CartaoSUS(infoPaciente.get("Cartão SUS"), "123");
        Profissao profissao = new Profissao(infoPaciente.get("Profissão"));
        Paciente paciente = new Paciente(infoPaciente.get("Nome completo"), "codigoPaciente", infoPaciente.get("CPF"), infoPaciente.get("Naturalidade"), infoPaciente.get("Nome da mãe"), residencia, data, profissao, cartaoSUS);
        return paciente;
    }

    public boolean salvar(HashMap<String, String> infoPaciente) {
        try {
            Paciente paciente = criaPaciente(infoPaciente);
            op.insertPaciente(paciente);
            return true;
        } catch (Exception erro) {
            log.EscreveNoLog("Erro ao salvar na AcolhimentoController: "+erro.getMessage());
            JOptionPane.showMessageDialog(null, erro.getMessage());
            return false;
        }

    }

    public synchronized static FramePrincipal singletonGetInstanceOfFramePrincipal() {
        if (fp == null) {
            fp = new FramePrincipal();
        }
        return fp;
    }

}
