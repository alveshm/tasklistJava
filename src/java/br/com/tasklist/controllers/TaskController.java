/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tasklist.controllers;

import br.com.tasklist.dao.TaskDAO;
import br.com.tasklist.model.Task;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author matheus
 */
@Controller
public class TaskController {
    
    @RequestMapping("index")
    public ModelAndView index(Model model, Task task) {
        
        if (task.getNome() != null) {
            saveForm(task);   
        }
        tasksList(model);
        
        return new ModelAndView("index");
    }
    
    public void saveForm(Task task) {
        TaskDAO dao = new TaskDAO();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LocalDate localDate = LocalDate.now();
        String now = dtf.format(localDate);
        task.setDataInicio(now);
        try {
            dao.add(task);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void tasksList(Model model) {
        TaskDAO dao = new TaskDAO();
        try {
            if (dao.listAll() != null) {
                model.addAttribute("tasks", dao.listAll());
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
        
    @RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
    public String removeTask(@PathVariable("id") int id, Model model) {
        TaskDAO dao = new TaskDAO();
        try {
            dao.remove(id);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return "redirect:/index";
    }
    
    @RequestMapping(value = "editar")
    public void editTask(@RequestParam("id") int id, Model model, Task task) {
        TaskDAO dao = new TaskDAO();
        
        try {
            model.addAttribute("id", id);
            model.addAttribute("nome", dao.findById(id).getNome());
            model.addAttribute("descricao", dao.findById(id).getDescricao());
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    @RequestMapping(value = "editTask")
    public String saveEditTask(@RequestParam("id") int id, Model model, Task task) {
        TaskDAO dao = new TaskDAO();
        
        try {
            task.setId(id);
            dao.update(task);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return "redirect:/index";
    }
    
    @RequestMapping(value = "updateStatus/{id}", method = RequestMethod.GET)
    public String saveEditTask(@PathVariable("id") int id, Model model) {
        TaskDAO dao = new TaskDAO();
        
        try {
            Task task;
            task = dao.findById(id);
            task.setStatus("concluido");
            dao.update(task);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return "redirect:/index";
    }
}
