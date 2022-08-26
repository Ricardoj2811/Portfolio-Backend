
package com.portfolio.rn.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String nombre;
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String apellido;
    @NotNull
    private String img;
    @NotNull
    private String descripcion;
    @NotNull
    private String carrera;
    private String carreraDos;
    private String linkedIn;
    private String gitHub;
    private String correo;


    public Persona() {
    }

    public Persona(String nombre, String apellido, String img, String descripcion, String carrera, String carreraDos, String linkedIn, String gitHub, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.descripcion = descripcion;
        this.carrera = carrera;
        this.carreraDos = carreraDos;
        this.linkedIn = linkedIn;
        this.gitHub = gitHub;
        this.correo = correo;
    }    

}
