
package com.portfolio.rn.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEd;
    private String descripcionEd;
    private String nombreInstitutoEd;
    private String fechaInicioEd;
    private String fechaFinalEd;
    private String imagenEd;
    private String linkEd;

    public Educacion() {
    }

    public Educacion(String nombreEd, String descripcionEd, String nombreInstitutoEd, String fechaInicioEd, String fechaFinalEd, String imagenEd, String linkEd) {
        this.nombreEd = nombreEd;
        this.descripcionEd = descripcionEd;
        this.nombreInstitutoEd = nombreInstitutoEd;
        this.fechaInicioEd = fechaInicioEd;
        this.fechaFinalEd = fechaFinalEd;
        this.imagenEd = imagenEd;
        this.linkEd = linkEd;
    }
}
