/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.Log;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author luizfritsch
 */
public class Paciente {

    private String nomePaciente;
    private String codigoPaciente;
    private String CPF;
    private String naturalidade;
    private String nomeMae;
    private Residencia residencia;
    private Date dataNascimento;
    private Profissao profissao;
    private CartaoSUS cartaoSUS;
    private Log log;

    public Paciente(String nomePaciente, String codigoPaciente, String CPF, String naturalidade, String nomeMae, Residencia residencia, Date dataNascimento, Profissao profissao, CartaoSUS cartaoSUS) {
        try {
            this.nomePaciente = nomePaciente;
            this.codigoPaciente = codigoPaciente;
            this.CPF = CPF;
            this.naturalidade = naturalidade;
            this.nomeMae = nomeMae;
            this.residencia = residencia;
            this.dataNascimento = dataNascimento;
            this.profissao = profissao;
            this.cartaoSUS = cartaoSUS;
        } catch (Exception erro) {
            log = new Log();
            log.EscreveNoLog("Erro ao criar um paciente: " + erro.getMessage());
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(String codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public Residencia getResidencia() {
        return residencia;
    }

    public void setResidencia(Residencia residencia) {
        this.residencia = residencia;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    public CartaoSUS getCartaoSUS() {
        return cartaoSUS;
    }

    public void setCartaoSUS(CartaoSUS cartaoSUS) {
        this.cartaoSUS = cartaoSUS;
    }

    @Override
    public String toString() {
        return "Paciente{" + "nomePaciente=" + nomePaciente + ", codigoPaciente=" + codigoPaciente + ", CPF=" + CPF + ", naturalidade=" + naturalidade + ", nomeMae=" + nomeMae + ", residencia=" + residencia + ", dataNascimento=" + dataNascimento + ", profissao=" + profissao + ", cartaoSUS=" + cartaoSUS + '}';
    }

}
