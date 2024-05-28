import java.io.*;
import java.util.Scanner;
import java.util.List; 
import java.io.File;

public class Mostrar {
    public static void mostrarTodosCadastrados() {
        System.out.println("\n");
        System.out.println(" Informações Cadastradas:");
        System.out.println("*********************************");
        try {
            File TrabalhadoresFile = new File("trabalhadores.txt");
            Scanner trabalhadoresScanner = new Scanner(TrabalhadoresFile);
            while (trabalhadoresScanner.hasNextLine()) {
                System.out.println(trabalhadoresScanner.nextLine());
            }
            trabalhadoresScanner.close();
            System.out.println("*********************************");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao exibir as informações cadastradas.");
            e.printStackTrace();
        }
    }
}
