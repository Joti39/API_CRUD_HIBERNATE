
package com.aplicacion.cursos.service;

import com.aplicacion.cursos.dto.TemaAEditarDTO;
import com.aplicacion.cursos.dto.TemaDTO;
import com.aplicacion.cursos.model.Curso;
import com.aplicacion.cursos.model.Tema;
import com.aplicacion.cursos.repository.ICursoRepository;
import com.aplicacion.cursos.repository.ITemaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TemaService implements ITemaService {
    
    @Autowired 
    ITemaRepository temaRep;
    @Autowired
    ICursoRepository cursoRep;
    
    @Override
    public Tema saveTema(TemaDTO tema) {
        Tema temaAGuardar = new Tema();
        Curso curso = cursoRep.getReferenceById(tema.getId_curso());
        
        temaAGuardar.setNombre_tema(tema.getNombre_tema());
        temaAGuardar.setDescripcion_tema(tema.getDescripcion_tema());
        temaAGuardar.setCurso(curso);
        
        return temaRep.save(temaAGuardar);
    }

    @Override
    public Tema editTema(TemaAEditarDTO temaDTO) {
        
       Long id_temaAModificar = temaDTO.getId_temaDTO();
       Long id_curso = temaDTO.getId_cursoDTO();
       Optional<Tema> posibleTema = temaRep.findById(id_temaAModificar);
       
       
       if (posibleTema.isPresent()) {
           
           Tema temaAGuardar = posibleTema.get();
           temaAGuardar.setId_tema(id_temaAModificar);
           temaAGuardar.setNombre_tema(temaDTO.getNombre_temaDTO());
           temaAGuardar.setDescripcion_tema(temaDTO.getDescripcion_temaDTO());

           return temaRep.save(temaAGuardar);
       }
       else {
           
           return null;
       }
    }
    
}
