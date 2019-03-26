/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author MarcoAntonio
 */
public class CartaoSUSExceptions extends Exception {

    public CartaoSUSExceptions() {
    }

    public CartaoSUSExceptions(String mensagem) {
        super(mensagem);
    }

    public CartaoSUSExceptions(Throwable causa) {
        super(causa);
    }

    public CartaoSUSExceptions(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
