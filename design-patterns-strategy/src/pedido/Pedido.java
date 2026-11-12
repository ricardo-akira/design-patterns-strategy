package pedido;

import strategies.Pagamento;

public class Pedido {

    private int custoTotal = 0;
    private boolean isFechado = false;

    public void processarPedido(Pagamento estrategia){
        estrategia.pegarDetalhesPagamento();
    }

    public int getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(int custoTotal) {
        this.custoTotal += custoTotal;
    }

    public boolean isFechado() {
        return isFechado;
    }

    public void setFechado() {
        isFechado = true;
    }
}
