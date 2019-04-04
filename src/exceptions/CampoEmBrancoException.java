/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author luizfritsch
 */
public class CampoEmBrancoException extends Exception {

    public CampoEmBrancoException() {
    }

    public CampoEmBrancoException(String mensagem) {
        super(mensagem);
    }

    public CampoEmBrancoException(Throwable causa) {
        super(causa);
    }

    public CampoEmBrancoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
