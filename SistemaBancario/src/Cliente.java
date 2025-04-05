import java.util.regex.Pattern;

public class Cliente {

    private String nome;
    private int idade;
    private String cpf;
    private int id;

    private static int contadorId = 0;

    public Cliente(String nome, int idade, String cpf) {
        if (nome.isBlank() || nome.equals(null)) {
            throw new NullPointerException("O nome não pode ser vazio!");
        }
        if (idade < 18) {
            throw new IllegalArgumentException("Você não pode criar uma conta sendo menor de 18 anos!");
        }
        if (!Pattern.matches("^\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}$", cpf)) {
            throw new IllegalArgumentException("CPF inválido! O formato correto é 000.000.000-00");
        }
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.id = ++contadorId;
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

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

}
