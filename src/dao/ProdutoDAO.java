package dao;

import javafx.collections.ObservableList;
import jdbc.ConnectionFactory;
import livraria.Autor;
import produtos.LivroFisico;
import produtos.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static javafx.collections.FXCollections.observableArrayList;

public class ProdutoDAO {

	public ObservableList<Produto> lista(){

        ObservableList<Produto> produtos = observableArrayList();
        PreparedStatement pstm;

        try(Connection conn = new ConnectionFactory().getConnection()){
            pstm = conn.prepareStatement("select * from produtos");
            ResultSet rs = pstm.executeQuery();

            while (rs.next()){
                LivroFisico livroFisico = new LivroFisico(new Autor());
                livroFisico.setNome(rs.getString("nome"));
                livroFisico.setDescricao(rs.getString("descricao"));
                livroFisico.setValor(rs.getLong("valor"));
                livroFisico.setIsbn(rs.getString("isbn"));
                produtos.add(livroFisico);
            }
            rs.close();
            pstm.close();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return produtos;
    }

    public void adiciona(Produto produto){
        String sql = "insert into produtos (nome,descricao,valor,isbn) values(?,?,?,?)";
        PreparedStatement pstm = null;

        try(Connection conn = new ConnectionFactory().getConnection()){
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getDescricao());
            pstm.setDouble(3, produto.getValor());
            pstm.setString(4, produto.getIsbn());
            pstm.execute();
            pstm.close();
            conn.close();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
