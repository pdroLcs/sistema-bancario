import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public final class Banco {

    private static Map<Integer, Cliente> clientes = new HashMap<>();
    private static Map<Integer, Conta> contas = new HashMap<>();
    private static int proximoIdCliente = 1;
    private static int proximoNumeroConta = 1000;

    private static Scanner input = new Scanner(System.in);

    private Banco() {
    }

    public static void adicionarCliente() {
        try {
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
        } catch (InputMismatchException e) {
            System.out.println("Digite um número válido!");
            input.nextLine();
        }
    }

    /*
     * public static void criarConta() {
     * System.out.print("Digite o ID do cliente: ");
     * int id = input.nextInt();
     * input.nextLine();
     * if (!clientes.containsKey(id)) {
     * throw new IllegalArgumentException("Cliente não encontrado!");
     * }
     * System.out.print("Digite a agência: ");
     * String agencia = input.nextLine();
     * TipoConta tipo = null;
     * while (tipo == null) {
     * try {
     * System.out.println("[1] CORRENTE\n[2] POUPANÇA\n[3] SALÁRIO");
     * System.out.print("Insira o tipo de conta: ");
     * int selecionaTipo = input.nextInt();
     * switch (selecionaTipo) {
     * case 1 -> tipo = TipoConta.CORRENTE;
     * case 2 -> tipo = TipoConta.POUPANCA;
     * case 3 -> tipo = TipoConta.SALARIO;
     * default -> System.out.println("Opção inválida! Tente novamente!");
     * }
     * } catch (InputMismatchException e) {
     * System.out.println("Entrada inválida! Digite um número de 1 a 3!");
     * input.nextLine();
     * }
     * }
     * Conta conta = new Conta(clientes.get(id), agencia, tipo);
     * contas.put(proximoNumeroConta, conta);
     * System.out.printf("Conta criada: Número: %d | Tipo: %s\n",
     * conta.getNumeroConta(), tipo.name());
     * proximoNumeroConta++;
     * }
     */

    public static void criarConta() {
        try {
            System.out.print("Digite o ID do cliente: ");
            int id = input.nextInt();
            input.nextLine();
            if (!clientes.containsKey(id)) {
                throw new IllegalArgumentException("Cliente não encontrado!");
            }
            System.out.print("Digite a agência: ");
            String agencia = input.nextLine();
            TipoConta tipo = null;
            while (tipo == null) {
                System.out.println("[1] CORRENTE\n[2] POUPANÇA\n[3] SALÁRIO");
                System.out.print("Insira o tipo de conta: ");
                int selecionaTipo = input.nextInt();
                switch (selecionaTipo) {
                    case 1 -> tipo = TipoConta.CORRENTE;
                    case 2 -> tipo = TipoConta.POUPANCA;
                    case 3 -> tipo = TipoConta.SALARIO;
                    default -> System.out.println("Opção inválida! Tente novamente!");
                }
            }
            Conta conta = new Conta(clientes.get(id), agencia, tipo);
            contas.put(proximoNumeroConta, conta);
            System.out.printf("Conta criada: Número: %d | Tipo: %s\n",
                    conta.getNumeroConta(), tipo.name());
            proximoNumeroConta++;
        } catch (InputMismatchException e) {
            System.out.println("Digite apenas números inteiros!");
            input.nextLine();
        }
    }

    public static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Não existe nenhum cliente cadastrado!");
            return;
        }
        for (Cliente c : clientes.values()) {
            System.out.printf("ID: %d | Nome: %s\n", c.getId(), c.getNome());
        }
    }

    public static void listarContas() {
        if (contas.isEmpty()) {
            System.out.println("Não existe nenhuma conta cadastrada!");
            return;
        }
        for (Conta c : contas.values()) {
            System.out.printf("Conta: %d | ID do cliente: %d | Tipo: %s\n", c.getNumeroConta(), c.getDono().getId(),
                    c.getTipo().name());
        }
    }

    public static Conta encontrarConta(int id) {
        for (Conta c : contas.values()) {
            if (c.getNumeroConta() == id) {
                return c;
            }
        }
        throw new IllegalArgumentException("Conta não encontrada!");
    }

    public static Conta encontrarConta(String strId) {
        try {
            int id = Integer.parseInt(strId);
            for (Conta c : contas.values()) {
                if (c.getNumeroConta() == id) {
                    return c;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: O número fornecido não é um número válido!");
        }
        throw new IllegalArgumentException("Conta não encontrada!");
    }

    public static void infoConta() {
        System.out.print("Digite o número da conta: ");
        int numero = input.nextInt();
        Conta conta = Banco.encontrarConta(numero);
        System.out.println(conta.toString());
    }

    public static void sacar() {
        System.out.print("Digite o número da conta: ");
        String numero = input.nextLine();
        Conta conta = encontrarConta(numero);
        System.out.print("Digite o valor para sacar: ");
        float valor = input.nextFloat();
        conta.sacar(valor);
    }

    public static void depositar() {
        System.out.print("Digite o número da conta: ");
        int numero = input.nextInt();
        Conta conta = encontrarConta(numero);
        System.out.print("Digite o valor para depositar: ");
        float valor = input.nextFloat();
        conta.depositar(valor);
    }

    public static void tranferir() {
        System.out.print("Digite o número da conta origem: ");
        int numeroOrigem = input.nextInt();
        Conta contaOrigem = encontrarConta(numeroOrigem);
        System.out.print("Digite o número da conta destino: ");
        int numeroDestino = input.nextInt();
        Conta contaDestino = Banco.encontrarConta(numeroDestino);
        System.out.print("Digite o valor para transferir: ");
        float valor = input.nextFloat();
        contaOrigem.transferir(valor, contaDestino);
    }

}