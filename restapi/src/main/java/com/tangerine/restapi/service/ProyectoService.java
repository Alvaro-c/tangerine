package com.tangerine.restapi.service;

import com.tangerine.restapi.model.Proyecto;
import com.tangerine.restapi.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Victor Romero (Tangerine)
 * @version 0.0.1
 * Clase que se encarga de recoger las peticiones del controlador y solicitar al Repositorio
 * de proyectos la accion pertinente
 */
@Service
public class ProyectoService {

    @Autowired
    ProyectoRepository proyectoRepository;

    /**
     * Metodo que recupera una lista con los proyectos en la base de datos
     * @return List<Proyecto>
     */
    public List<Proyecto> findAll() {
        return proyectoRepository.findAll();
    }

    /**
     * Metodo que recupera un objeto Proyecto de la base de datos en funcion del ID
     * @param id
     * @return Proyecto
     */
    public Optional<Proyecto> findById(Integer id) {
        return proyectoRepository.findById(id);
    }

    /**
     * Metodo que guarda un objeto Proyecto en la base de datos
     * @param proyecto
     * @return Proyecto
     */
    public Proyecto saveProyecto(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    public void deleteProyecto(Integer id){
        proyectoRepository.deleteById(id);
    }


}
