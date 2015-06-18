package utilitarios;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import livraria.Autor;
import produtos.Livro;
import produtos.LivroFisico;
import produtos.Produto;


public class Exportador {
	public void paraCSV(List<Produto> produtos) throws IOException {
		try {
			PrintStream ps = new PrintStream("produtos.csv");
			ps.println("Nome, Descrição, Valor, ISBN");

			for (Produto produto : produtos) {
				ps.println(String.format("%s,%s,%s,%s", produto.getNome(),
						produto.getDescricao(), produto.getValor(),
						produto.getIsbn()));
			}
			ps.close();
		} catch (IOException e) {
			System.out.println("Erro ao criar o documento :" + e);
		}
	}

	public static void main(String[] args) throws IOException {

		Livro livro = new LivroFisico(new Autor());
		livro.setNome("Java 8 Prático");
		livro.setDescricao("Novos recursos da linguagem");
		livro.setValor(59.90);
		livro.setIsbn("978-85-66250-46-6");

		Livro maisUmlivro = new LivroFisico(new Autor());
		maisUmlivro.setNome("Desbravando a O.O.");
		maisUmlivro.setDescricao("Livro de Java e O.O");
		maisUmlivro.setValor(59.90);
		maisUmlivro.setIsbn("321-54-67890-11-2");
		new Exportador().paraCSV(Arrays.asList(livro, maisUmlivro));
	}
}
