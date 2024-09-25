
package com.aplicacion.cursos.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
public class Curso {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_curso;
    private String nombre_curso;
    private String modalidad;
    private String fecha_finalizacion;
    @OneToMany(mappedBy="curso")
    @JsonManagedReference //Para que JSON no haga bucles al mostrar resultados, ponemos esta annotation bajo OneToMany
    private List<Tema> listaTemas;

    public Curso() {
    }
    public Curso(Long id_curso, String nombre_curso, String modalidad, String fecha_finalizacion) {
        this.id_curso = id_curso;
        this.nombre_curso = nombre_curso;
        this.modalidad = modalidad;
        this.fecha_finalizacion = fecha_finalizacion;
        
    }
    public Curso(Long id_curso, String nombre_curso, String modalidad, String fecha_finalizacion, List<Tema> listaTemas) {
        this.id_curso = id_curso;
        this.nombre_curso = nombre_curso;
        this.modalidad = modalidad;
        this.fecha_finalizacion = fecha_finalizacion;
        this.listaTemas = listaTemas;
    }
    
    
    
    
}
