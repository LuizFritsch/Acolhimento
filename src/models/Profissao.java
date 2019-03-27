/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author luizfritsch
 */
public class Profissao {
    
    private String nomeProfissao;

    public Profissao() {
    }

    public Profissao(String nomeProfissao) {
        this.nomeProfissao = nomeProfissao;
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
