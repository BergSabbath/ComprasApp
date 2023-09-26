import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o limite do cartão:");
        double limite = entrada.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        int continuar = 1;

        while(continuar == 1) {
            System.out.println("Digite a descrição da compra:");
            String descricao = entrada.next();

            System.out.println("Digite o valor da compra:");
            double valor = entrada.nextDouble();

            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if (compraRealizada) {
                System.out.println("Compra realizada!");
                System.out.println("Digite 1 para continuar ou qualquer tecla para sair");
                continuar = entrada.nextInt();
            } else {
                System.out.println("Você não possui saldo suficiente!");
                continuar = 0;
            }
        }
            System.out.println("**********************************");
            System.out.println("Compras realizadas:\n");
            Collections.sort(cartao.getCompras());
            for (Compra c : cartao.getCompras()) {
                System.out.println(c.getDescricao() + " - " + c.getValor());
            }
            System.out.println("**********************************");
            System.out.println("\nSaldo do cartão: " + cartao.getSaldo());

    }
}