import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int opcao = 0;
        while (opcao != 7) {
            System.out.println(
                    "[1] CADASTRAR CLIENTE\n[2] CRIAR CONTA\n[3] SACAR\n[4] DEPOSITAR\n[5] TRANSFERIR\n[6] VERIFICAR SALDO\n[7] SAIR");
            System.out.print("Digite sua opção: ");
            try {
                opcao = input.nextInt();
                switch (opcao) {
                    case 1:
                        Banco.adicionarCliente();
                        break;
                    case 2:
                        Banco.criarConta();
                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:
                        System.out.println("Programa encerrado!");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número inválido!");
                input.nextLine();
            }
        }
        input.close();
    }
}