public class Cliente {

    private String nome;
    private int idade;
    private String cpf;

    public Cliente(String nome, int idade, String cpf) {
        if (idade < 18) {
            throw new IllegalArgumentException("Você não pode criar uma conta sendo menor de 18 anos!");
        }
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return int return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @return String return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
