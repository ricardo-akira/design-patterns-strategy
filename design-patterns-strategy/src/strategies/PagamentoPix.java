package strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PagamentoPix implements Pagamento {
    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String senha;
    private boolean conectado;

    static {
        DATA_BASE.put("1234", "usuario@gmail.com");
        DATA_BASE.put("admin", "admin@outlook.com");
    }

    @Override
    public void pegarDetalhesPagamento() {
        try{
            while (!conectado){
                System.out.print("Digite o email da conta Pix: ");
                email = READER.readLine();
                System.out.print("Digite a senha: ");
                senha = READER.readLine();
                if (verificar()){
                    System.out.println("Dados verificados com sucesso!");
                } else {
                    System.out.println("Email ou senha errados!");
                }
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private boolean verificar(){
        setConectado(email.equals(DATA_BASE.get(senha)));
        return conectado;
    }

    @Override
    public boolean pagar(int valorPagamento) {
        if (conectado) {
            System.out.println("Pagando R$" + valorPagamento + " usando Pix.");
            return true;
        } else {
            return false;
        }
    }

    private void setConectado(boolean conectado){
        this.conectado = conectado;
    }
}
