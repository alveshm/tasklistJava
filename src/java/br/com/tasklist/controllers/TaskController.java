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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author matheus
 */
@Controller
public class TaskController {
    
    @RequestMapping("index")
    public ModelAndView saveForm(Model model, Task task) {
        
        TaskDAO dao = new TaskDAO();
        
        try {
            dao.add(task);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        try {
            if (dao.listAll() != null) {
                model.addAttribute("tasks", dao.listAll());
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return new ModelAndView("index");
    }
    
    
}
