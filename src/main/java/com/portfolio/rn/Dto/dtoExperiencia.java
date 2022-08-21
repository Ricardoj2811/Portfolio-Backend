
package com.portfolio.rn.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoExperiencia {
    @NotBlank
    private String nombreE;
    private String descripcionE;
    private String nombreEmpresaE;
    private String fechaInicioE;
    private String fechaFinalE;
    private String imagen;
    private String link;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String descripcionE, String nombreEmpresaE, String fechaInicioE, String fechaFinalE, String imagen, String link) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.nombreEmpresaE = nombreEmpresaE;
        this.fechaInicioE = fechaInicioE;
        this.fechaFinalE = fechaFinalE;
        this.imagen = imagen;
        this.link = link;
    }
}
