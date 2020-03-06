package estudo;

import lombok.Data;

@Data
public class Produto implements Comparable<Produto> {
  private int id;
  private String nome;
  private double valor;
  private int quantidadeEmEstoque;
  private Categoria categoria;

  public Produto(int id, String nome, double valor, int quantidadeEmEstoque, Categoria categoria) {
    this.id = id;
    this.nome = nome;
    this.valor = valor;
    this.quantidadeEmEstoque = quantidadeEmEstoque;
    this.categoria = categoria;
  }

  public int compareTo(Produto produto) {
    return this.id - produto.id;
  }
}
