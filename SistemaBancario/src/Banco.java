import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Banco {

    private static Map<Integer, Cliente> clientes = new HashMap<>();
    private static Map<Integer, Conta> contas = new HashMap<>();
    private static int proximoIdCliente = 1;
    private static int proximoNumeroConta = 1000;

    private static Scanner input = new Scanner(System.in);

    public static void adicionarCliente() {
        System.out.print("Digite o nome: ");
        String nome = input.nextLine();
        System.out.print("Digite a idade: ");
        int idade = input.nextInt();
        input.nextLine();
        System.out.print("Digite o CPF: ");
        String cpf = input.nextLine();
        Cliente cliente = new Cliente(nome, idade, cpf);
        clientes.put(proximoIdCliente, cliente);
        System.out.printf("Cliente cadastrado: Nome: %s | ID: %d\n", nome, proximoIdCliente);
        proximoIdCliente++;
    }

    public static void criarConta() {
        System.out.print("Digite o ID do cliente: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Digite a agência: ");
        String agencia = input.nextLine();
        TipoConta tipo = null;
        while (tipo == null) {
            try {
                System.out.println("[1] CORRENTE\n[2] POUPANÇA\n[3] SALÁRIO");
                System.out.print("Insira o tipo de conta: ");
                int selecionaTipo = input.nextInt();
                switch (selecionaTipo) {
                    case 1 -> tipo = TipoConta.CORRENTE;
                    case 2 -> tipo = TipoConta.POUPANCA;
                    case 3 -> tipo = TipoConta.SALARIO;
                    default -> System.out.println("Opção inválida! Tente novamente!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número de 1 a 3!");
                input.nextLine();
            }
        }
        Conta conta = new Conta(clientes.get(id), agencia, tipo);
        contas.put(proximoNumeroConta, conta);
        System.out.printf("Conta criada: Número: %d | Tipo: %s\n",
                proximoNumeroConta, tipo.name());
        proximoNumeroConta++;
        /*
         * if (!clientes.containsKey(idCliente)) {
         * throw new IllegalArgumentException("Cliente não encontrado!");
         * }
         * 
         */
    }

    public static void listarClientes() {
        for (Cliente c : clientes.values()) {
            System.out.printf("ID: %d | Nome: %s | CPF: %s\n", c.getId(), c.getNome(), c.getCpf());
        }
    }

    public static void listarContas() {
        for (Conta c : contas.values()) {
            System.out.printf("Conta: %d | ID do cliente: %d | Tipo: %s\n", c.getNumeroConta(), c.getDono().getId(),
                    c.getTipo().name());
        }
    }

}
