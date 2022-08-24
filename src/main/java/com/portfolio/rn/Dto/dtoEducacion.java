
package com.portfolio.rn.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoEducacion {
    @NotBlank
    private String nombreEd;
    private String descripcionEd;
    private String nombreInstitutoEd;
    private String fechaInicioEd;
    private String fechaFinalEd;
    private String imagenEd;
    private String linkEd;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreEd, String descripcionEd, String nombreInstitutoEd, String fechaInicioEd, String fechaFinalEd, String imagenEd, String linkEd) {
        this.nombreEd = nombreEd;
        this.descripcionEd = descripcionEd;
        this.nombreInstitutoEd = nombreInstitutoEd;
        this.fechaInicioEd = fechaInicioEd;
        this.fechaFinalEd = fechaFinalEd;
        this.imagenEd = imagenEd;
        this.linkEd = linkEd;
    }
    
}
