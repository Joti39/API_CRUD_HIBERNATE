
package com.aplicacion.cursos.service;


import com.aplicacion.cursos.model.Curso;
import com.aplicacion.cursos.dto.CursoAEditarDTO;
import com.aplicacion.cursos.model.Tema;
import com.aplicacion.cursos.repository.ICursoRepository;
import com.aplicacion.cursos.repository.ITemaRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService implements ICursoService {

    @Autowired 
            ICursoRepository cursoRep;
    @Autowired 
            ITemaRepository temaRep;
    
    @Override
    public Curso saveCurso(CursoAEditarDTO curso) {
       Curso cursoAguardar = new Curso();
       
       cursoAguardar.setId_curso(curso.getId_cursoDTO());
       cursoAguardar.setNombre_curso(curso.getNombre_cursoDTO());
       cursoAguardar.setModalidad(curso.getModalidadDTO());
       cursoAguardar.setFecha_finalizacion(curso.getFecha_finalizacionDTO());

       return cursoRep.save(cursoAguardar);
    }

    @Override
    public List<Curso> getCursos() {
        return cursoRep.findAll();
    }
    //AQUÍ ME QUEDÉ
    @Override
    public List<Tema> getTemasCurso(Long id_curso) {
       Optional<Curso> posibleCurso = cursoRep.findById(id_curso);
       if (posibleCurso.isPresent()) {
           return posibleCurso.get().getListaTemas();
       }
       return null;
       
    }

    @Override
    public List<String> getCursosJava() {
        
        List<Curso> listaCursos = this.getCursos();
        List<String> cursosJava = new ArrayList <>();
        String cadenaBuscada = "JAVA";
        
        for (Curso cur : listaCursos) {
            
            if (cur.getNombre_curso().toUpperCase().contains(cadenaBuscada)) {
                cursosJava.add(cur.getNombre_curso());
            }
        }
        return cursosJava;
        
       
    }

    @Override
    public Curso editCurso(CursoAEditarDTO cursoDTO) {
        
       Long id_cursoAModificar = cursoDTO.getId_cursoDTO();
       Optional<Curso> posibleCurso = cursoRep.findById(id_cursoAModificar);
       
       if (posibleCurso.isPresent()) {
           
           Curso cursoAGuardar = posibleCurso.get();
           cursoAGuardar.setId_curso(id_cursoAModificar);
           cursoAGuardar.setNombre_curso(cursoDTO.getNombre_cursoDTO());
           cursoAGuardar.setModalidad(cursoDTO.getModalidadDTO());
           cursoAGuardar.setFecha_finalizacion(cursoDTO.getFecha_finalizacionDTO());
           
           return cursoRep.save(cursoAGuardar);
       }
       else {
           
           return null;
       }
       
    }
    
}
