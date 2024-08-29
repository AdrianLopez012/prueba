package com.example.tarea2_20192733.controller;

import com.example.tarea2_20192733.model.Estudiante;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TareaController {
    private List<Estudiante> estudiantes = new ArrayList<>();

    // Por el método formulario podremos obtener la ruta para ver la vista del formulario
    @GetMapping("/formulario")
    public String mostrarFormulario() {
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardarEstudiante(
            @RequestParam("nombre") String nombre,
            @RequestParam("apellido") String apellido,
            @RequestParam("dni") String dni,
            @RequestParam("codigoPUCP") String codigoPUCP,
            @RequestParam("direccion") String direccion,
            Model model) {

        // Nos servirá para poder observar en consola los datos ingresados en el formulario
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("DNI: " + dni);
        System.out.println("Código PUCP: " + codigoPUCP);
        System.out.println("Dirección: " + direccion);

        // Creamos el objeto estudiante donde guardaremos los datos obtenidos en el formulario donde lo utilizaramos para el tablero de la lista de estudiantes
        Estudiante estudiante = new Estudiante(nombre, apellido, dni, codigoPUCP, direccion);
        estudiantes.add(estudiante);

        // Añadimos la lista de estudiantes al modelo para poder utilizarlo en las vistas
        model.addAttribute("estudiantes", estudiantes);

        return "listaEstudiantes";
    }
}
