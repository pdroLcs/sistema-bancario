public class Conta {

    private Cliente dono;
    private String agencia;
    private float saldo;
    private TipoConta tipo;
    private int numeroConta;

    private static int contas = 1000;

    public Conta(Cliente dono, String agencia, TipoConta tipo) {
        this.dono = dono;
        this.agencia = agencia;
        this.tipo = tipo;
        this.numeroConta = ++contas;
    }

    /**
     * @return Cliente return the dono
     */
    public Cliente getDono() {
        return dono;
    }

    /**
     * @param dono the dono to set
     */
    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    /**
     * @return String return the agencia
     */
    public String getAgencia() {
        return agencia;
    }

    /**
     * @param agencia the agencia to set
     */
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    /**
     * @return float return the saldo
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    /**
     * @return TipoConta return the tipo
     */
    public TipoConta getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoConta tipo) {
        this.tipo = tipo;
    }

    /**
     * @return int return the numeroConta
     */
    public int getNumeroConta() {
        return numeroConta;
    }

    /**
     * @param numeroConta the numeroConta to set
     */
    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void sacar(float valor) {
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente para o saque!");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Impossível sacar valor menor ou igual à 0!");
        }
        saldo -= valor;
        System.out.printf("Saque no valor de R$%.2f realizado!", valor);
    }

    public void depositar(float valor) {
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente para o depósito!");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Impossível depositar valor menor ou igual à 0!");
        }
        saldo += valor;
        System.out.printf("Depósito no valor de R$%.2f realizado!", valor);
    }

    public void transferir(float valor, Conta contaDestino) {
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente para a transferência!");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Impossível tranferir valor menor ou igual à 0!");
        }
        this.saldo -= valor;
        contaDestino.saldo += valor;
    }
}