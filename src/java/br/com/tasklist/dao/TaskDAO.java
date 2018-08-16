/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tasklist.dao;

import br.com.tasklist.model.Task;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author matheus
 */
public class TaskDAO {
    public void adiciona(Task task) throws SQLException {
        
        Conexao conn = new Conexao();
        
        String sql = "INSERT INTO tasks(nome, descricao) VALUES (?, ?)";
        
        PreparedStatement ps = conn.getConexao().prepareStatement(sql);
        
        ps.setString(1, task.getNome());
        ps.setString(2, task.getDescricao());
        //ps.setDate(3, (Date) task.getDataInicio());
        
        ps.execute();
    }
        
}
