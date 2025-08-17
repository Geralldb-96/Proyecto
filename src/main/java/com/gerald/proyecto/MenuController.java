package com.gerald.proyecto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    // Mapea la ruta raíz "/" y devuelve la vista "menu"
    @GetMapping("/")
    public String mostrarMenu() {
        return "menu";  // Spring Boot busca 'menu.html' en src/main/resources/templates
    }
}
