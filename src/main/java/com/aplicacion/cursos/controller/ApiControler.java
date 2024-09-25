
package com.aplicacion.cursos.controller;

import com.aplicacion.cursos.dto.CursoDTO;
import com.aplicacion.cursos.dto.TemaDTO;
import com.aplicacion.cursos.model.Curso;
import com.aplicacion.cursos.dto.CursoAEditarDTO;
import com.aplicacion.cursos.dto.TemaAEditarDTO;
import com.aplicacion.cursos.model.Tema;

import com.aplicacion.cursos.service.ICursoService;
import com.aplicacion.cursos.service.ITemaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiControler {
    
    @Autowired ICursoService cursoServ;
    @Autowired ITemaService temaServ;
    
    @PostMapping("/curso/alta")
    public String saveCurso(@RequestBody CursoAEditarDTO curso){
        
        cursoServ.saveCurso(curso);

        return "El curso fue creado satisfactoriamente";
    }
    @PostMapping("/tema/alta")
    public String saveTema(@RequestBody TemaDTO tema){
        
        temaServ.saveTema(tema);

        return "El tema fue creado satisfactoriamente";
    }
    @PostMapping("/temas/alta")
    public String saveTemas(@RequestBody List<TemaDTO> listaTemas){
        
        for (TemaDTO tema : listaTemas) {
            
            temaServ.saveTema(tema);
        }
        

        return "Los temas fueron creados satisfactoriamente";
    }
    @GetMapping("/cursos/consulta")
    public List<Curso> getCursos(){
        
        return cursoServ.getCursos();
    }
    @GetMapping("/curso/temas/{idCurso}")
    public String getTemasCurso(@PathVariable Long idCurso){
        
        List <Tema> listaTemas = cursoServ.getTemasCurso(idCurso);
        List<String> titulosTemas = new ArrayList<String>();
        
        if (listaTemas != null){
            for (Tema tem : listaTemas){
                titulosTemas.add(tem.getNombre_tema());
                
            }
            return " " + titulosTemas;
        }
        
        return "El curso con el identificador "+ idCurso + " no existe";
    }
    @GetMapping("/cursos/java")
    public List<String> getCursosJava(){
        
        return cursoServ.getCursosJava();
    }
    @PutMapping("/curso/editar")
    public String editCurso(@RequestBody CursoAEditarDTO curso) {
        
        cursoServ.editCurso(curso);
        
        return "El curso ha sido actualizado";
        
    }
    @PutMapping("/tema/editar")
    public String editTema(@RequestBody TemaAEditarDTO tema) {
        
        temaServ.editTema(tema);
        
        return "El tema ha sido actualizado";
        
    }
    
}
