package org.yourcompany.projetomaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCPostgres {

    public static void main(String[] args) {
       
        String url = "jdbc:postgresql://localhost:5432/rocket_db";
        Properties props = new Properties();
        Connection conn;

        props.setProperty("user", "postgres");
        props.setProperty("password", "admin");
        // props.setProperty("ssl", "true");

        try {
            conn = DriverManager.getConnection(url, props);
            System.out.println("Conectado com sucesso");

            
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados");
            e.printStackTrace();
        }
    }
}
