package strategies;

public class CartaoCredito {
    private int valor;
    private String numero;
    private String data;
    private String cvv;

    CartaoCredito(String numero, String data, String cvv) {
        this.valor = 100_000;
        this.numero = numero;
        this.data = data;
        this.cvv = cvv;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
