package com.tecsup.lab12.controlador;

import com.tecsup.lab12.modelo.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PersonaControlador {

    @GetMapping("/personas")
    public String mostrarPersonas(Model model) {
        List<Persona> lista = List.of(
                new Persona("Ana", 28),
                new Persona("Luis", 35),
                new Persona("Maria", 22)
        );
        model.addAttribute("personas", lista);
        return "personas";
    }
}
