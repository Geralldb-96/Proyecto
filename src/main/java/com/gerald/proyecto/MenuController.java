package com.gerald.proyecto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MenuController {

    // Menu principal
 @GetMapping("/menu")
    public String menu(Model model) {
        model.addAttribute("nombreUsuario", ""); // lo llenaremos con JS
        return "menu";
    }


    // ---------- CLIMA ----------
    @GetMapping("/clima")
    public String climaForm() {
        return "clima"; 
    }

    @PostMapping("/clima")
    public String procesarClima(@RequestParam double temp, Model model) {
        String mensaje;
        if (temp < 10) {
            mensaje = "Hace mucho frio. Abrigate bien!";
        } else if (temp <= 25) {
            mensaje = "Clima agradable. Disfruta el dia.";
        } else {
            mensaje = "Hace calor. Hidratate!";
        }
        model.addAttribute("temp", temp);
        model.addAttribute("mensaje", mensaje);
        return "clima";
    }

    // ---------- EDAD ----------
    @GetMapping("/edad")
    public String edadForm() {
        return "edad";
    }

    @PostMapping("/edad")
    public String procesarEdad(@RequestParam int anio, Model model) {
        int edad = 2025 - anio;
        String mensaje = (edad >= 18) ? "Eres mayor de edad." : "Eres menor de edad.";
        model.addAttribute("edad", edad);
        model.addAttribute("mensaje", mensaje);
        return "edad";
    }

    // ---------- CONTAR DEL 1 AL X ----------
    @GetMapping("/x")
    public String xForm() {
        return "x";
    }

    @PostMapping("/x")
    public String procesarX(@RequestParam int numero, Model model) {
        if (numero <= 0) {
            model.addAttribute("error", "El numero debe ser positivo.");
        } else {
            StringBuilder conteo = new StringBuilder();
            for (int i = 1; i <= numero; i++) {
                conteo.append(i).append(" ");
            }
            model.addAttribute("conteo", conteo.toString());
        }
        return "x";
    }

    // ---------- ADIVINA ----------
    @GetMapping("/adivina")
    public String adivinaForm() {
        return "adivina";
    }

    @PostMapping("/adivina")
    public String procesarAdivina(@RequestParam int intento, Model model) {
        int secreto = 7;
        String mensaje;
        if (intento < secreto) {
            mensaje = "Demasiado bajo. Intenta de nuevo.";
        } else if (intento > secreto) {
            mensaje = "Demasiado alto. Intenta de nuevo.";
        } else {
            mensaje = "Felicidades! Adivinaste el numero.";
        }
        model.addAttribute("mensaje", mensaje);
        return "adivina";
    }
}
