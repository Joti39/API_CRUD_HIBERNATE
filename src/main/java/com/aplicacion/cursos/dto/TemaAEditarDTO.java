
package com.aplicacion.cursos.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TemaAEditarDTO implements Serializable {
    
    private Long id_temaDTO;
    private String nombre_temaDTO;
    private String descripcion_temaDTO;
    private Long id_cursoDTO;

    public TemaAEditarDTO() {
    }

    public TemaAEditarDTO(Long id_temaDTO, String nombre_temaDTO, String descripcion_temaDTO, Long id_cursoDTO) {
        this.id_temaDTO = id_temaDTO;
        this.nombre_temaDTO = nombre_temaDTO;
        this.descripcion_temaDTO = descripcion_temaDTO;
        this.id_cursoDTO = id_cursoDTO;
    }
    
    
    
    
}
