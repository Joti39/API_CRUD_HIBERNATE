
package com.aplicacion.cursos.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CursoDTO implements Serializable{
    
    
    private String nombre_curso;
    private String modalidad;
    private String fecha_finalizacion;
    

    public CursoDTO() {
    }

    public CursoDTO(String nombre_curso, String modalidad, String fecha_finalizacion) {
        
        this.nombre_curso = nombre_curso;
        this.modalidad = modalidad;
        this.fecha_finalizacion = fecha_finalizacion;
        
    }

  
    
    
}
