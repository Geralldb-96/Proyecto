package com.gerald.proyecto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    @GetMapping("/menu")
    public String menu(Model model) {
        model.addAttribute("nombreUsuario", ""); // lo llenaremos con JS
        return "menu";
    }
    @GetMapping("/clima")
    public String clima() {
        return "clima"; // archivo clima.html
    }
}
