
package com.portfolio.rn.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoProyectos {
    @NotBlank
    private String nombreP;
    private String descripcionP;
    private String imagenP;
    private String linkP;

    public dtoProyectos() {
    }

    public dtoProyectos(String nombreP, String descripcionP, String imagenP, String linkP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.imagenP = imagenP;
        this.linkP = linkP;
    }
    
    
    
}
