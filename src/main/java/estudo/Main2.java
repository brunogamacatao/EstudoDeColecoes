package estudo;

import java.text.NumberFormat;
import java.util.List;

public class Main2 {
  public static void main(String[] args) {
    List<Produto> produtos = Util.criarProdutos();

    // Ordena usando o compareTo da classe Produto
    System.out.println("Produtos ordenados pelo ID");
    produtos.stream().sorted().forEach(p -> System.out.println(p));

    System.out.println("\nProdutos em ordem alfabética");
    produtos.stream()
        .sorted((p1, p2) -> p1.getNome().compareTo(p2.getNome()))
        .forEach(p -> System.out.println(p));


    System.out.println("\nProdutos ordenados pelo valor (do menor para o maior)");
    produtos.stream()
        .sorted((p1, p2) -> (int)(p1.getValor() * 100 - p2.getValor() * 100))
        .forEach(p -> System.out.println(p));

    System.out.println("\nApenas os produtos em estoque ordenados pelo valor");
    produtos.stream()
        .filter(p -> p.getQuantidadeEmEstoque() > 0)
        .sorted((p1, p2) -> (int)(p1.getValor() * 100 - p2.getValor() * 100))
        .forEach(p -> System.out.println(p));

    System.out.println("\nApenas os produtos de informática, em ordem alfabética, com 20% de desconto");
    produtos.stream()
        .filter(p -> p.getCategoria() == Categoria.INFORMATICA)
        .sorted((p1, p2) -> p1.getNome().compareTo(p2.getNome()))
        .map(p -> new Produto(p.getId(), p.getNome(), 0.8 * p.getValor(), p.getQuantidadeEmEstoque(), p.getCategoria()))
        .forEach(p -> System.out.println(p));

    System.out.println("\nValor total dos produtos de higiene");

    double total =
        produtos.stream()
        .filter(p -> p.getCategoria() == Categoria.HIGIENE)
        .map(p -> p.getValor())
        .reduce(0.0, (a, b) -> a + b);

    System.out.println(total);
    System.out.println(NumberFormat.getCurrencyInstance().format(total));
  }
}
