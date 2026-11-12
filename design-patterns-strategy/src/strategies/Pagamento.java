package strategies;

public interface Pagamento {
    boolean pagar(int valorPagamento);
    void pegarDetalhesPagamento();
}
