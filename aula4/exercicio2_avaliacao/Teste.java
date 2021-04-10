import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Simão Pedro Sá Cunha A93262
 * @author Tiago Luís Dias da Silva A93277 
 * PL2
 */
public class Teste {
    public static void main(String[] args) {
        EncEficiente encomenda = new EncEficiente("Gervasio", 42424242, "Rua da Central", 42, LocalDate.now(),new ArrayList<LinhaEncomenda>());
        System.out.println("Encomenda #1: " + encomenda.toString());
        System.out.println("-------------------------------------------");

        LinhaEncomenda linha1 = new LinhaEncomenda("r1v234", "Ajax - limpa-vidros", 3.99, 5, 50, 15);
        encomenda.adicionaLinha(linha1); 

        LinhaEncomenda linha2 = new LinhaEncomenda("r43x21", "Beyblade", 9.99, 15, 10, 10);
        encomenda.adicionaLinha(linha2); 
        System.out.println("Encomenda #1 (Atualizada): " + encomenda.toString());

        System.out.println("-------------------------------------------");

        System.out.println("Valor total da encomenda = " + encomenda.calculaValorTotal()   +"\n");

        System.out.println("Valor total dos descontos = "+ encomenda.calculaValorDesconto()+"\n");

        System.out.println("Número total de produtos = "+ encomenda.numeroTotalProdutos()+"\n");

        System.out.println("O produto 'r1v234' vai ser encomendado? "+ (encomenda.existeProdutoEncomenda("r1v234") ? " Sim \n" : " Não \n") );
        System.out.println("O produto 'daa545c' vai ser encomendado? "+ (encomenda.existeProdutoEncomenda("daa545c") ? " Sim\n" : " Não\n"));

        encomenda.removeProduto("r1v234");
        System.out.println("Produto 'r1v234' removido.\n");

        System.out.printf("O produto 'r1v234' vai ser encomendado?" +(encomenda.existeProdutoEncomenda("24680") ? " Sim\n" : " Não\n"));
    }

}
