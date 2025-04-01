public class App {
    public static void main(String[] args) throws Exception {
        try {
            Conta c1 = new Conta(new Cliente("João", 17, "123.456.78-90"), "123-A", TipoConta.POUPANCA);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
