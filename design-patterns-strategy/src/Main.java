import pedido.Pedido;
import strategies.PagamentoCartaoCredito;
import strategies.PagamentoCartaoDebito;
import strategies.PagamentoPix;
import strategies.Pagamento;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<Integer, Integer> precoDosProdutos = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Pedido pedido = new Pedido();
    private static Pagamento pagamento;

    static {
        precoDosProdutos.put(1, 2200);
        precoDosProdutos.put(2, 1850);
        precoDosProdutos.put(3, 1100);
        precoDosProdutos.put(4, 890);
    }

    void main() throws IOException {
        while (!pedido.isFechado()){
            int custo;

            String continuarEscolha;
            do {
                System.out.print("Selecione um produto: " + "\n" +
                        "1 - Placa-mãe R$2200" + "\n" +
                        "2 - CPU R$2200" + "\n" +
                        "3 - HDD R$2200" + "\n" +
                        "4 - Memória R$2200" + "\n");
                int escolha = Integer.parseInt(reader.readLine());
                custo = precoDosProdutos.get(escolha);
                System.out.print("Quantidade: ");
                int quantidade = Integer.parseInt(reader.readLine());
                pedido.setCustoTotal(custo * quantidade);
                switch (escolha){
                    case 1 -> System.out.printf("%S Placa-mãe adicionada(s) ao carrinho ",quantidade);
                    case 2 -> System.out.printf("%S CPU adicionada(s) ao carrinho ",quantidade);
                    case 3 -> System.out.printf("%S HDD adicionada(s) ao carrinho ",quantidade);
                    case 4 -> System.out.printf("%S Memória(s) adicionada(s) ao carrinho ",quantidade);
                }
                System.out.print("\nDeseja continuar adicionando itens no carrinho? S/N: ");
                continuarEscolha = reader.readLine();
            } while (continuarEscolha.equalsIgnoreCase("S"));

            if (pagamento == null) {
                int carrinho = pedido.getCustoTotal();
                System.out.println("=================================================");
                System.out.printf("Total do carrinho: R$%s", carrinho);
                System.out.println("\nPor favor selecione um método de pagamento:" + "\n" +
                        "1 - Pix" + "\n" +
                        "2 - Cartão de Crédito" + "\n" +
                        "3 - Cartão de Débito");
                String metodoPagamento = reader.readLine();

                System.out.println("=================================================");
                if (metodoPagamento.equals("1")){
                    pagamento = new PagamentoPix();
                    System.out.println("Pagamento via Pix");
                } else if (metodoPagamento.equals("2")){
                    pagamento = new PagamentoCartaoCredito();
                    System.out.println("Pagamento via Cartão de Crédito");
                } else {
                    pagamento = new PagamentoCartaoDebito();
                    System.out.println("Pagamento via Cartão de Débito");
                }

            }

            pedido.processarPedido(pagamento);

            System.out.println("=================================================");
            if (pagamento.pagar(pedido.getCustoTotal())) {
                System.out.println("Pagamento feito com sucesso!");
            } else {
                System.out.println("ERRO! Por favor, verifique seus dados.");
            }
            pedido.setFechado();

        }
    }
}
