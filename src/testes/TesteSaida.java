package testes;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by eduardo on 09/06/15.
 */
public class TesteSaida {
    public static void main(String[] args) throws IOException{
        OutputStream os = System.out;
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);

        bw.write("Testando a escrita");
        bw.newLine();
        bw.write("Conteúdo da próxima linha");
        bw.newLine();
        bw.write("Testando o OutPutStream, da API de IO do Java.");
        bw.close();


    }
}
