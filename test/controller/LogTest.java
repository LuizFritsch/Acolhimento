/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author luizfritsch
 */
public class LogTest {

    public LogTest() {
    }

    /**
     * Test of EscreveNoLog method, of class Log.
     */
    @Test
    public void testEscreveNoLog() {
        String erro = "";
        Log instance = new Log();
        instance.EscreveNoLog(erro);
    }

}
