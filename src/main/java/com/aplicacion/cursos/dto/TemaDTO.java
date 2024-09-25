
package com.aplicacion.cursos.dto;


import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TemaDTO implements Serializable{
    
    
    private String nombre_tema;
    private String descripcion_tema;
    private Long id_curso;
    private List<TemaDTO> listaTemasDTO;
    

    public TemaDTO() {
    }

    public TemaDTO(String nombre_tema, String descripcion_tema, Long id_curso, List<TemaDTO> listaTemasDTO) {
        this.nombre_tema = nombre_tema;
        this.descripcion_tema = descripcion_tema;
        this.id_curso = id_curso;
        this.listaTemasDTO = listaTemasDTO;
    }

    

   

   
    
}
