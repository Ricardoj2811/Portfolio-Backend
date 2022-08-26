
package com.portfolio.rn.Service;

import com.portfolio.rn.Entity.Persona;
import com.portfolio.rn.Interface.IPersonaService;
import com.portfolio.rn.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpPersonaService implements IPersonaService{
    @Autowired 
    IPersonaRepository ipersonaRepository;
    
    public List<Persona> getPersona() {
        List<Persona> persona = ipersonaRepository.findAll();
        return persona;
    }

    public void save(Persona persona) {
        ipersonaRepository.save(persona);
    }
    
    public Optional<Persona> getOne(int id){
        return ipersonaRepository.findById(id);
    }
    
    public Optional<Persona> getByNombre(String nombre){
        return ipersonaRepository.findByNombre(nombre);
    }

    public void deletePersona(int id) {
       ipersonaRepository.deleteById(id);
    }

    public Persona findPersona(int id) {
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        return persona;
    }
    
    public boolean existsById(int id){
        return ipersonaRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return ipersonaRepository.existsByNombre(nombre);
    }

    @Override
    public void savePersona(Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
