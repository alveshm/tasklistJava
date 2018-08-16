/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tasklist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author matheus
 */
@Controller
public class Teste {
    
    @RequestMapping("/olaMundo")
    public String iniciando() {
        return "index";
    }
}
