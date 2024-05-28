import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar trabalhador");
            System.out.println("2. Consultar endereço pelo CEP");
            System.out.println("3. Mostrar todos os cadastrados");
            System.out.println("4. Sair");
            System.out.print("Opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    Cadastrar.cadastrarTrabalhador();
                    break;
                case 2:
                    Consultar.consultarEnderecoPeloCEP();
                    break;
                case 3:
                    Mostrar.mostrarTodosCadastrados();
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}
