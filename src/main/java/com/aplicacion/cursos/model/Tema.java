
package com.aplicacion.cursos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Tema {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id_tema;
    private String nombre_tema;
    private String descripcion_tema;
    @ManyToOne
    @JoinColumn(name="curso_id")
    @JsonBackReference ////Para que JSON no haga bucles al mostrar resultados, ponemos esta annotation bajo ManyToOne
    private Curso curso;

    public Tema() {
    }

    public Tema(long id_tema, String nombre_tema, String descripcion_tema, Curso curso) {
        this.id_tema = id_tema;
        this.nombre_tema = nombre_tema;
        this.descripcion_tema = descripcion_tema;
        this.curso = curso;
    }

    
    
    
    
    
}
