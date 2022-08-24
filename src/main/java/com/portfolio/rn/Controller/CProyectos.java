
package com.portfolio.rn.Controller;

import com.portfolio.rn.Dto.dtoProyectos;
import com.portfolio.rn.Entity.Proyectos;
import com.portfolio.rn.Security.Controller.Mensaje;
import com.portfolio.rn.Service.SProyectos;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("proy")
@CrossOrigin(origins = "http://localhost:4200")
public class CProyectos {
    @Autowired
    SProyectos sProyectos;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = sProyectos.List();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoeproy){
        if(StringUtils.isBlank(dtoeproy.getNombreP()))
            return new ResponseEntity(new Mensaje("El nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        if(sProyectos.existsByNombreP(dtoeproy.getNombreP()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
        Proyectos proyectos = new Proyectos(dtoeproy.getNombreP(), dtoeproy.getDescripcionP(), dtoeproy.getImagenP(), dtoeproy.getLinkP());
        sProyectos.save(proyectos);
        
        return new ResponseEntity(new Mensaje("Experiencia Agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoproy){
        if(!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        if(sProyectos.existsByNombreP(dtoproy.getNombreP()) && sProyectos.getByNombreP(dtoproy.getNombreP()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa Experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoproy.getNombreP()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyectos proyectos = sProyectos.getOne(id).get();
        proyectos.setNombreP(dtoproy.getNombreP());
        proyectos.setDescripcionP(dtoproy.getDescripcionP());
        proyectos.setImagenP(dtoproy.getImagenP());
        proyectos.setLinkP(dtoproy.getLinkP());
        
        
        sProyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("Experiencia Actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sProyectos.delete(id);
        
        return new ResponseEntity(new Mensaje("Experiencia Borrada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyectos proyectos = sProyectos.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
}
