package testes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by eduardo on 09/06/15.
 */
public class TesteLeituraTexto {

    public static void main(String args[]){
        try {
            InputStream is = new FileInputStream("saida.txt");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            String linha = reader.readLine();

            while (linha != null){
                System.out.println(linha);
                linha = reader.readLine();
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("Erro ao tentar ler o arquivo" + e);
        }
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Digite seu nome:");
        String nome = sc.nextLine();
        System.out.println("Digite sua idade");
        Integer idade = sc.nextInt();
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);*/



    }
}
