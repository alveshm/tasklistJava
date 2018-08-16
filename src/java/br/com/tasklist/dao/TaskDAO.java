/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tasklist.dao;

import br.com.tasklist.model.Task;
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
        
        String sql = "INSERT INTO tasks(nome, descricao, dataInicio) VALUES (?, ?, ?)";
        
        PreparedStatement ps = conn.getConexao().prepareStatement(sql);
        
        ps.setString(1, task.getNome());
        ps.setString(2, task.getDescricao());
        ps.setString(3, task.getDataInicio());
        
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
            task.setDataInicio(rs.getString("dataInicio"));
            task.setStatus(rs.getString("status"));
            
            allTasks.add(task);
            
        }
        
        return allTasks;
    }
    public Task findById(int id) throws SQLException {
        Task task = new Task();
        String sql = "SELECT * FROM tasks WHERE id = ?";
        
        PreparedStatement ps = conn.getConexao().prepareStatement(sql);
        
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {  
            task.setId(rs.getInt("id"));
            task.setNome(rs.getString("nome"));
            task.setDataInicio(rs.getString("dataInicio"));
            task.setDescricao(rs.getString("descricao"));
        }
        return task;
    }
    public void update(Task task) throws SQLException {
        String sql = "UPDATE tasks " +
                    "SET nome = ?,  ";
        if (task.getStatus() != null) {
            sql += "descricao = ?,";
            sql += "status = ? ";
        }else {
            sql += "descricao = ?";
        }
        sql += " WHERE id = ?";
                    
                
         PreparedStatement ps = conn.getConexao().prepareStatement(sql);
         
        
        ps.setString(1, task.getNome());
        ps.setString(2, task.getDescricao());
        if (task.getStatus() != null) {
            ps.setString(3, task.getStatus());
            ps.setInt(4, task.getId());
        }else {
            ps.setInt(3, task.getId());
        }
            
        
        
        
        ps.execute();
    }
    public void remove(int id) throws SQLException {
        
        String sql = "DELETE FROM tasks WHERE id = ?";
        
        PreparedStatement ps = conn.getConexao().prepareStatement(sql);        
        
        ps.setInt(1, id);
        ps.execute();
    }
        
}
