package com.tangerine.restapi.repository;

import com.tangerine.restapi.model.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajeRepository extends JpaRepository <Mensaje, Integer> {


}
