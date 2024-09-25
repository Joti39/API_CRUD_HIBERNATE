
package com.aplicacion.cursos.repository;

import com.aplicacion.cursos.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITemaRepository extends JpaRepository<Tema, Long>{
    
}
