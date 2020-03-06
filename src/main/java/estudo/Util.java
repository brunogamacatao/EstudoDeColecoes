package estudo;

import java.util.ArrayList;
import java.util.List;

public class Util {
  public static List<Produto> criarProdutos() {
    List<Produto> produtos = new ArrayList<>();

    produtos.add(new Produto(2, "Pen Drive 128gb", 42.0, 3, Categoria.INFORMATICA));
    produtos.add(new Produto(4, "Laranja Kg", 5.0, 15, Categoria.ALIMENTACAO));
    produtos.add(new Produto(0, "Notebook Acer", 1800.0, 10, Categoria.INFORMATICA));
    produtos.add(new Produto(1, "Mouse", 30.5, 0, Categoria.INFORMATICA));
    produtos.add(new Produto(6, "Shampoo", 17, 4, Categoria.HIGIENE));
    produtos.add(new Produto(3, "Hamburguer", 10.0, 20, Categoria.ALIMENTACAO));
    produtos.add(new Produto(5, "Sabonete", 3.25, 30, Categoria.HIGIENE));

    return produtos;
  }
}
