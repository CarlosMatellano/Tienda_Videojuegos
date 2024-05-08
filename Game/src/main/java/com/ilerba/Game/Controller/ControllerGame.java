/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ilerba.Game.Controller;

import com.ilerba.Game.Entity.Juego;
import org.springframework.ui.Model;
import com.ilerba.Game.Service.GestorGame;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Alumno
 */
@Controller
@RequestMapping("/game")
public class ControllerGame {

    GestorGame gg = new GestorGame();

    @GetMapping("/")
    public String crud(Model model) {
        String valorfinal = "./game/listargameold";
        try {
            model.addAttribute("juego", gg.listar());
        } catch (SQLException ex) {
            Logger.getLogger(ControllerGame.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
            valorfinal = "error";
        }
        return valorfinal;
    }

    @GetMapping("/alta")
    public String greetingForm(Model model) {
        model.addAttribute("juego", new Juego());
        return "./game/altagame";
    }

    @PostMapping("/alta")
    public String greetingSubmit(@ModelAttribute Juego juego, Model model) {
        String valorfinal = "redirect:/game/";
        try {
            gg.alta(juego);
            try {
                model.addAttribute("juego", gg.listar());
            } catch (SQLException ex) {
                Logger.getLogger(ControllerGame.class.getName()).log(Level.SEVERE, null, ex);
                valorfinal = "error";
            }
        } catch (SQLException ex) {
            valorfinal = "error";
        }
        return valorfinal;
    }
}
