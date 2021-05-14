package com.tangerine.restapi.service;


import com.tangerine.restapi.model.Persona;
import com.tangerine.restapi.model.Proyecto;
import com.tangerine.restapi.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    /**
     * Metodo que recupera una lista con las personas  en la base de datos
     *
     * @return List<Persona>
     */
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }
    /**
     * Metodo que recupera una persona de la base de datos a partir de la id
     *
     * @param id
     * @return Optional<Persona>
     */
    public Optional<Persona> findById(Integer id) {
        return personaRepository.findById(id);
    }
    /**
     * Metodo que guarda objeto Persona en la base de datos
     *
     * @param persona
     * @return Persona
     */
    public Persona savePersona(Persona persona) {
        return personaRepository.save(persona);
    }


}
