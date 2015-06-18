package testes;

/**
 * Created by eduardo on 15/06/15.
 */
public class TestaThreads {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("Rodando em paralelo, de novo")).start();

        System.out.println("Terminei de rodar o main");
    }
}
