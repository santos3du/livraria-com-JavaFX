package testes;

import livraria.Autor;
import produtos.LivroFisico;
import dao.ProdutoDAO;

/**
 * Created by eduardo on 11/06/15.
 */
public class TesteAdiciona {
    public static void main(String[] args) {
        Autor autor = new Autor();
        autor.setNome("Eduardo Santos");

        LivroFisico livroFisico = new LivroFisico(autor);
        livroFisico.setNome("O sucesso do Segredo");
        livroFisico.setDescricao("Nova forma de encarar o novo.");
        livroFisico.setValor(55.80);
        livroFisico.setIsbn("");

        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.adiciona(livroFisico);

        System.out.println("Adicinado com sucesso " + livroFisico.getClass());

    }
}
