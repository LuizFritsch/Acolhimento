/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author MarcoAntonio
 */
public class AcolhimentoController {
    private String sexo [];
    private String cSUS;
    
    public AcolhimentoController(){
        setSexo();
        cSUS = "";
    }

    private String[] getSexo() {
        return sexo;
    }   
    
    private void setSexo(){
        this.sexo[0] = "Masculino";
        this.sexo[1] = "Feminino";
    }
    
    private void setcSUS(){
         
    }
    
}
