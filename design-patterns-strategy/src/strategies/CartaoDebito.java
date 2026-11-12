package strategies;

public class CartaoDebito {
    private int valor;
    private String numero;
    private String data;
    private String cvv;

    CartaoDebito(String numero, String data, String cvv) {
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
