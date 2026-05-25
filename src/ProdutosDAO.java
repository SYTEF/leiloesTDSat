/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){

        String sql = "insert into produtos (nome, valor, status) values (?, ?, ?)";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());

            prep.execute();
            prep.close();

            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + erro);

        }

    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){

        String sql = "select * from produtos";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);
            resultset = prep.executeQuery();

            listagem.clear(); // ✅ Mantido para não duplicar itens na tabela visual

            while(resultset.next()){

                ProdutosDTO produto = new ProdutosDTO();

                produto.setId(resultset.getInt("id"));
                produto.setNome(resultset.getString("nome"));
                produto.setValor(resultset.getInt("valor"));
                produto.setStatus(resultset.getString("status"));

                listagem.add(produto);

            }

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + erro);

        }

        return listagem;
    }
    
    public void venderProduto(int id){

        String sql = "update produtos set status = 'Vendido' where id = ?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setInt(1, id);

            prep.executeUpdate();

            JOptionPane.showMessageDialog(null, "Produto vendido com sucesso!");

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro ao vender produto: " + erro);

        }

    }  
    
    public ArrayList<ProdutosDTO> listarProdutosVendidos(){

        ArrayList<ProdutosDTO> vendidos = new ArrayList<>();

        String sql = "select * from produtos where status = 'Vendido'";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            resultset = prep.executeQuery();

            while(resultset.next()){

                ProdutosDTO produto = new ProdutosDTO();

                produto.setId(resultset.getInt("id"));
                produto.setNome(resultset.getString("nome"));
                produto.setValor(resultset.getInt("valor"));
                produto.setStatus(resultset.getString("status"));

                vendidos.add(produto);

            }

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro ao listar vendidos: " + erro);

        }

        return vendidos;
    }  
        
}