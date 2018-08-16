/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tasklist.dao;

import br.com.tasklist.model.Task;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matheus
 */
public class TaskDAO {
    private Conexao conn = new Conexao();
    public void add(Task task) throws SQLException {
        
        String sql = "INSERT INTO tasks(nome, descricao) VALUES (?, ?)";
        
        PreparedStatement ps = conn.getConexao().prepareStatement(sql);
        
        ps.setString(1, task.getNome());
        ps.setString(2, task.getDescricao());
        //ps.setDate(3, (Date) task.getDataInicio());
        
        ps.execute();
    }
    
    public List<Task> listAll() throws SQLException {
        List<Task> allTasks = new ArrayList<>();
        String sql = "SELECT * FROM tasks";
        
        PreparedStatement ps = conn.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            Task task = new Task();
            
            task.setId(rs.getInt("id"));
            task.setNome(rs.getString("nome"));
            task.setDescricao(rs.getString("descricao"));
            
            allTasks.add(task);
            
        }
        
        return allTasks;
    }
        
}
