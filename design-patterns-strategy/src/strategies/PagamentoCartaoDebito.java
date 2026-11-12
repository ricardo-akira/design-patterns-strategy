package strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PagamentoCartaoDebito implements Pagamento {

    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private CartaoDebito cartaoDebito;

    @Override
    public void pegarDetalhesPagamento() {
        try {
            System.out.print("Digite o número do cartão: ");
            String numero = READER.readLine();
            System.out.print("Digite a data de validade do cartão: ");
            String data = READER.readLine();
            System.out.print("Digite o CVV do cartão: ");
            String cvv = READER.readLine();
            cartaoDebito = new CartaoDebito(numero, data, cvv);
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public boolean pagar(int valorPagamento) {
        if (cartaoPresente()) {
            System.out.println("Pagando R$" + valorPagamento + " usando cartão de débito.");
            cartaoDebito.setValor(cartaoDebito.getValor() - valorPagamento);
            return true;
        } else {
            return false;
        }
    }

    private boolean cartaoPresente(){
        return cartaoDebito != null;
    }
}
