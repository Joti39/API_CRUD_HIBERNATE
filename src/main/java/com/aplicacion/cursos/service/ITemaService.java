
package com.aplicacion.cursos.service;

import com.aplicacion.cursos.dto.TemaAEditarDTO;
import com.aplicacion.cursos.dto.TemaDTO;
import com.aplicacion.cursos.model.Tema;

public interface ITemaService {
    
    public Tema saveTema(TemaDTO tema);
    
    public Tema editTema(TemaAEditarDTO tema);
    
}
