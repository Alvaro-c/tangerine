package com.tangerine.restapi.controller;

import com.tangerine.restapi.exceptions.ProjectNotFoundException;
import com.tangerine.restapi.model.Cliente;
import com.tangerine.restapi.model.Proyecto;
import com.tangerine.restapi.repository.ClienteRepository;
import com.tangerine.restapi.service.ClienteService;
import com.tangerine.restapi.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Controlador que mapea las peticiones que llegan a /api
 * Segun la url mapeada devolvera la informacion correspondiente desde la BBDD
 * Tiene injectadas dependencias de ProyectoService y ClienteService
 */
@RestController
@RequestMapping(path="/api")
public class ApiController {

    @Autowired
    ProyectoService proyectoService;

    @Autowired
    ClienteService clienteService;

    /**
     * Mapeando un GET en la ruta /api/proyecto devuelve una
     * lista de todos los proyectos de la BBDD
     * @return Lista de proyectos
     */
    @GetMapping("/proyecto")
    public List<Proyecto> getAllProyectos() {
        return proyectoService.findAll();
    }

    /**
     * Mapeando un GET en la ruta /api/idProyecto devuelve el
     * proyecto con ID espeficicada en la URL desde la BBDD
     * @param id
     * @return Proyecto con id especificado
     */
    @GetMapping("/proyecto/{id}")
    public Proyecto getProyecto(@PathVariable Integer id) {
        return proyectoService
                .findById(id)
                .orElseThrow(ProjectNotFoundException::new);
    }

    /**
     * Mapea un POST desde el formulario que hay en la ruta /proyecto
     * Ese formulario que cuando es enviado debe contener la informacion
     * de un nuevo proyecto es guardado en la BBDD
     * @param proyecto
     * @return Devuelve el mismo proyecto que es introducido
     */
    @PostMapping("/proyecto")
    public Proyecto saveProyecto(@RequestBody Proyecto proyecto) {
        return proyectoService.saveProyecto(proyecto);
    }

    /**
     * Mapea un GET desde la ruta /cliente y devuelve todos los clientes
     * que hay en la BBDD para poder mostrarlos en el formulario de
     * creacion de un nuevo proyecto
     * @return Lista de clientes
     */
    @GetMapping("/cliente")
    public List<Cliente> getAllCliente() {
        return clienteService.findAll();
    }
}
