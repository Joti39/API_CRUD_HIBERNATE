
package com.aplicacion.cursos.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CursoAEditarDTO implements Serializable {
    
    private Long id_cursoDTO;
    private String nombre_cursoDTO;
    private String modalidadDTO;
    private String fecha_finalizacionDTO;
    

    public CursoAEditarDTO() {
    }

    public CursoAEditarDTO(Long id_cursoDTO, String nombre_cursoDTO, String modalidadDTO, String fecha_finalizacionDTO) {
        this.id_cursoDTO = id_cursoDTO;
        this.nombre_cursoDTO = nombre_cursoDTO;
        this.modalidadDTO = modalidadDTO;
        this.fecha_finalizacionDTO = fecha_finalizacionDTO;
    }
    
    
}
