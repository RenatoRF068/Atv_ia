import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Cadastrar {
    public static void cadastrarTrabalhador() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe os dados do trabalhador:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
    
        System.out.print("Salário bruto: ");
        double salarioBruto = scanner.nextDouble();

        System.out.print("Desconto do INSS: ");
        double descontoINSS = scanner.nextDouble();

        System.out.print("Número de dependentes: ");
        int numDependentes = scanner.nextInt();

        System.out.print("Valor total de descontos para dedução de IRRF: ");
        double descontoIRRF = scanner.nextDouble();
        
        double salarioLiquido = salarioBruto - descontoINSS - descontoIRRF;
        
        System.out.print("CPF: ");
        String cpf = scanner.next();

        System.out.print("CEP: ");
        String cep = scanner.next();
        scanner.nextLine();
        
        System.out.print("Endereço: ");
        String endereco = scanner.next();
        scanner.nextLine();
        
        System.out.print("Salário líquido: " + salarioLiquido);
        

File Adicionarfile = new File("trabalhador.txt");
    try {
      if (Adicionarfile.createNewFile())
        System.out.println("Trabalhador adicionado" + "\n");
      else
        System.out.println("cpf já existe.");

      FileWriter writer = new FileWriter(Adicionarfile, true);
        writer.write(nome + ", ");
        writer.write(salarioBruto+ ", ");
        writer.write(descontoINSS + ", ");
        writer.write(numDependentes + ", ");
        writer.write(descontoIRRF + ", ");
        writer.write(cpf + ", ");
        writer.write(cep + ", ");
        writer.write(endereco + "\n");
        writer.close();

      } catch (IOException e) {
     System.out.println("Ocorreu um erro ao adicionar o trabalhador.");
     e.printStackTrace();
            }
  }



      }

