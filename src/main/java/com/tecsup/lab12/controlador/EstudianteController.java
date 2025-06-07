package com.tecsup.lab12.controlador;

import com.tecsup.lab12.modelo.Estudiante;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    private List<Estudiante> estudiantes = new ArrayList<>();
    private Long contadorId = 1L;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("estudiantes", estudiantes);
        return "index";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Estudiante estudiante) {
        if (estudiante.getId() == null) {
            estudiante.setId(contadorId++);
            estudiantes.add(estudiante);
        } else {
            for (int i = 0; i < estudiantes.size(); i++) {
                if (estudiantes.get(i).getId().equals(estudiante.getId())) {
                    estudiantes.set(i, estudiante);
                    break;
                }
            }
        }
        return "redirect:/estudiantes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        for (Estudiante e : estudiantes) {
            if (e.getId().equals(id)) {
                model.addAttribute("estudiante", e);
                return "form";
            }
        }
        return "redirect:/estudiantes";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        estudiantes.removeIf(e -> e.getId().equals(id));
        return "redirect:/estudiantes";
    }
}