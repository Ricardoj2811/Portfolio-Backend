
package com.portfolio.rn.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoSkills {
    @NotBlank
    private String nombreSk;
    private String imagenSk;
    private String PercentSk;

    public dtoSkills() {
    }

    public dtoSkills(String nombreSk, String imagenSk, String PercentSk) {
        this.nombreSk = nombreSk;
        this.imagenSk = imagenSk;
        this.PercentSk = PercentSk;
    }
    
}
