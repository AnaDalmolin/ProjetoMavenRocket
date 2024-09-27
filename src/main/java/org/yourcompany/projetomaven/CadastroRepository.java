package org.yourcompany.projetomaven;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CadastroRepository {
    
    private static Connection conexao;
    
    public CadastroRepository() {
        conexao = FabricaConexao.getConnection();
    }

    public void salvar(Cadastro cadastro){
        try {
            String sql = "INSERT INTO public.tab_cadastro (nome, idade) VALUES (?, ?);";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cadastro.getNome());
            stmt.setInt(2, cadastro.getIdade());  
            stmt.execute();
            System.out.println("Salvo com sucesso");    
        } catch (Exception e) {
            e.printStackTrace();
        }

       
    }
    public void alterar(Cadastro cadastro){
        try {
            String sql = "UPDATE public.tab_cadastro SET nome = ?, idade = ? WHERE id = ?;";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cadastro.getNome());
            stmt.setInt(2, cadastro.getIdade());
            stmt.setInt(3, cadastro.getId());
            stmt.execute();
            System.out.println("Alterado com sucesso");    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void excluir(Integer id){
        try {
            String sql = "DELETE FROM public.tab_cadastro WHERE id = ?;";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            System.out.println("Excluído com sucesso");    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Cadastro> listar() throws SQLException{
        List<Cadastro> cadastros = new ArrayList<>();
        try { 
            String sql = "SELECT id, nome, idade FROM public.tab_cadastro "; 
            PreparedStatement statement = conexao.prepareStatement(sql); 
            ResultSet result = statement.executeQuery(); 
            while (result.next()) { 
                Integer id = result.getInt("id"); 
                String nome = result.getString("nome"); 
                Integer idade = result.getInt("idade"); 
                Cadastro cadastro = new Cadastro();
                cadastro.setId(id);
                cadastro.setNome(nome);
                cadastro.setIdade(idade);
                cadastros.add(cadastro);
                System.out.println(id + " - " + nome + " - " + idade);

            } 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
        return cadastros;
    }
    
    public Cadastro buscar(Integer id){
        Cadastro cadastro = null;
        try { 
            String sql = "SELECT id, nome, idade FROM public.tab_cadastro WHERE id = ?"; 
            PreparedStatement statement = conexao.prepareStatement(sql); 
            statement.setInt(1, id); 
            ResultSet result = statement.executeQuery(); 
            if (result.next()) { 
                String nome = result.getString("nome"); 
                Integer idade = result.getInt("idade"); 
                cadastro = new Cadastro();
                cadastro.setId(id);
                cadastro.setNome(nome);
                cadastro.setIdade(idade);
                System.out.println("Cadastro encontrado: ");
                System.out.println(id + " - " + nome + " - " + idade);
                return cadastro;
            } 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
        System.out.println("Cadastro não encontrado");
        return cadastro;
    }
}
