
package com.portfolio.rn.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String descripcionE;
    private String nombreEmpresaE;
    private String fechaInicioE;
    private String fechaFinalE;
    private String imagen;
    private String link;

    public Experiencia() {
    }

    public Experiencia(String nombreE, String descripcionE, String nombreEmpresaE, String fechaInicioE, String fechaFinalE, String imagen, String link) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.nombreEmpresaE = nombreEmpresaE;
        this.fechaInicioE = fechaInicioE;
        this.fechaFinalE = fechaFinalE;
        this.imagen = imagen;
        this.link = link;
    }   
    
}
