import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int opcao = 0;
        while (opcao != 9) {
            System.out.println(
                    "[1] CADASTRAR CLIENTE\n[2] CRIAR CONTA\n[3] SACAR\n[4] DEPOSITAR\n[5] TRANSFERIR\n[6] VERIFICAR SALDO\n[7] LISTAR CLIENTES\n[8] LISTAR CONTAS\n[9] SAIR");
            System.out.print("Digite sua opção: ");
            try {
                opcao = input.nextInt();
                switch (opcao) {
                    case 1 -> Banco.adicionarCliente();
                    case 2 -> Banco.criarConta();
                    case 3 -> Banco.sacar();
                    case 4 -> Banco.depositar();
                    case 5 -> Banco.tranferir();
                    case 6 -> Banco.infoConta();
                    case 7 -> Banco.listarClientes();
                    case 8 -> Banco.listarContas();
                    case 9 -> System.out.println("Programa encerrado!");
                    default -> System.out.println("Opção inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número inválido!");
                input.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        input.close();
    }
}