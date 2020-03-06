package estudo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Produto> produtos = Util.criarProdutos();

    // Ordena pelo compareTo da classe Produto
    Collections.sort(produtos);

    System.out.println("Produtos pelo ID");
    for (Produto p : produtos) System.out.println(p);

    // Ordena os produtos em ordem alfabética, passando um comparator
    Collections.sort(produtos, new Comparator<Produto>() {
      @Override
      public int compare(Produto p1, Produto p2) {
        return p1.getNome().compareTo(p2.getNome());
      }
    });

    System.out.println("Produtos em ordem alfabética");
    for (Produto p : produtos) System.out.println(p);

    // Ordena os produtos em ordem alfabética, usando lambda
    Collections.sort(produtos, (p1, p2) -> p1.getNome().compareTo(p2.getNome()));

    System.out.println("Produtos em ordem alfabética (lambda)");
    for (Produto p : produtos) System.out.println(p);

    // Problema do Collections.sort: modifica a coleção original
  }
}
