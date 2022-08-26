
package com.portfolio.rn.Dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoPersona {
    @NotBlank
    private String nombre;
    private String apellido;
    private String img;
    private String descripcion;
    private String carrera;
    private String carreraDos;
    private String linkedIn;
    private String gitHub;
    private String correo;

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String img, String descripcion, String carrera, String carreraDos, String linkedIn, String gitHub, String correo) {
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
