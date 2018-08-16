/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tasklist.dao;

import com.mysql.jdbc.Connection;
import com.sun.istack.internal.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 *
 * @author matheus
 */
public class Conexao {
    
    private Connection conn;
    
    private void conectar() {
        System.out.println("Conectando ao banco...");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/testeSupero?zeroDateTimeBehavior=convertToNull", "matheus", "root");
            System.out.println("Conectado");
        } catch (ClassNotFoundException e) {
            System.out.println("Classe não encontrada, adicione o driver nas bibliotecas");
            java.util.logging.Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public Connection getConexao() {
        conectar();
        
        return conn;
    }
        
}
