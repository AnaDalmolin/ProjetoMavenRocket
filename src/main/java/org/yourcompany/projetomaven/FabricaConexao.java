package org.yourcompany.projetomaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FabricaConexao {
    private static Connection conexao;
    String url = "jdbc:postgresql://localhost:5432/rocket_db";
    Properties props = new Properties();
    Connection conn;


    public static void conectar(){
        String url = "jdbc:postgresql://localhost:5432/rocket_db";
        Properties props = new Properties();
        props.setProperty("user", "/*****");
        props.setProperty("password", "****");

        try {
            conexao = DriverManager.getConnection(url, props);
            System.out.println("Conectado com sucesso");

        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return conexao;
    }
    
}
