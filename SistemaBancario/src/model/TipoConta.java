package model;

public enum TipoConta {
    CORRENTE("Corrente"),
    POUPANCA("Poupança"),
    SALARIO("Salário");
    
    private final String nome;
    
    TipoConta(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
}
