import java.util.HashMap;
import java.util.Map;

public class Banco {

    private static Map<Integer, Cliente> clientes = new HashMap<>();
    private static Map<Integer, Conta> contas = new HashMap<>();
    private static int proximoIdCliente = 1;
    private static int proximoNumeroConta = 1000;

    public static void adicionarCliente(String nome, int idade, String cpf) {
        Cliente cliente = new Cliente(nome, idade, cpf);
        clientes.put(proximoIdCliente, cliente);
        System.out.printf("Cliente cadastrado: Nome: %s | ID: %d\n", nome, proximoIdCliente);
        proximoIdCliente++;
    }

    public static void criarConta(String agencia, TipoConta tipo, int idCliente) {
        if (!clientes.containsKey(idCliente)) {
            throw new IllegalArgumentException("Cliente não encontrado!");
        }
        Conta conta = new Conta(clientes.get(idCliente), agencia, tipo);
        contas.put(proximoNumeroConta, conta);
        System.out.printf("Conta criada: Número: %d | Tipo: %s\n", proximoNumeroConta, tipo.name());
        proximoNumeroConta++;
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
