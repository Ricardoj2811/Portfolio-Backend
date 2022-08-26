
package com.portfolio.rn.Interface;

import com.portfolio.rn.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    
    public List<Persona> getPersona();
    
    public void savePersona(Persona persona);
    
    public void deletePersona(int id);
    
    public Persona findPersona(int id);
   
}
