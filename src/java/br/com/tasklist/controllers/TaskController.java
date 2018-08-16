/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tasklist.controllers;

import br.com.tasklist.dao.TaskDAO;
import br.com.tasklist.model.Task;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author matheus
 */
@Controller
public class TaskController {
    
    @RequestMapping("index")
    public ModelAndView carregaIndex(Model model, Task task) {
        
        TaskDAO dao = new TaskDAO();
        
        try {
            dao.adiciona(task);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        model.addAttribute("teste", task.getNome());
        return new ModelAndView("index");
    }
}
