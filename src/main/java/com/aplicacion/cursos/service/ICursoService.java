
package com.aplicacion.cursos.service;

import com.aplicacion.cursos.dto.CursoDTO;
import com.aplicacion.cursos.model.Curso;
import com.aplicacion.cursos.dto.CursoAEditarDTO;
import com.aplicacion.cursos.model.Tema;
import java.util.List;

public interface ICursoService {
   public Curso saveCurso(CursoAEditarDTO curso);
   
   public List<Curso> getCursos();
   
   public List<Tema> getTemasCurso(Long id_curso);
   
   public List<String> getCursosJava();
   
   public Curso editCurso(CursoAEditarDTO curso);
}
