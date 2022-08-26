
package com.portfolio.rn.Controller;

import com.portfolio.rn.Dto.dtoPersona;
import com.portfolio.rn.Entity.Persona;
import com.portfolio.rn.Interface.IPersonaService;
import com.portfolio.rn.Security.Controller.Mensaje;
import com.portfolio.rn.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired 
    IPersonaService ipersonaService;
    
    @Autowired
    ImpPersonaService sPersona;
    
    @GetMapping("/traer/persona")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear/persona")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La Persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/persona/{id}")
    public String deletePersona(@PathVariable int id){
       ipersonaService.deletePersona(id);
       return "La persona fue eliminada correctamente";
    }
       
    @GetMapping ("traer/persona/{id}")
    public Persona findPersona(@PathVariable int id){
        return ipersonaService.findPersona(id);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtoper){
        if(!sPersona.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        if(sPersona.existsByNombre(dtoper.getNombre()) && sPersona.getByNombre(dtoper.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa Experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoper.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Persona persona = sPersona.getOne(id).get();
        persona.setNombre(dtoper.getNombre());
        persona.setApellido(dtoper.getApellido());
        persona.setImg(dtoper.getImg());
        persona.setDescripcion(dtoper.getDescripcion());
        persona.setCarrera(dtoper.getCarrera());
        persona.setCarreraDos(dtoper.getCarreraDos());
        persona.setLinkedIn(dtoper.getLinkedIn());
        persona.setGitHub(dtoper.getGitHub());
        persona.setCorreo(dtoper.getCorreo());
        
        sPersona.save(persona);
        return new ResponseEntity(new Mensaje("Experiencia Actualizada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!sPersona.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = sPersona.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
}
