package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

    private static final String PATH = "" + System.getProperty("user.dir");
    private static final String FILENAME = "" + PATH + "\\Log.txt";

    public void EscreveNoLog(String erro) {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            /**
             * Escreve no log a data e o erro que aconteceu
             */
            Date data = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            fw = new FileWriter(FILENAME,true); //O parametro true, faz com q dê append ao inves de criar um novo arquivo toda vez
            bw = new BufferedWriter(fw);
            bw.append(data + "  -  " + erro + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
