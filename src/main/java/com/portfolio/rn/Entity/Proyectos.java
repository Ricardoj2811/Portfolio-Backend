
package com.portfolio.rn.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreP;
    private String descripcionP;
    private String imagenP;
    private String linkP;

    public Proyectos() {
    }

    public Proyectos(String nombreP, String descripcionP, String imagenP, String linkP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.imagenP = imagenP;
        this.linkP = linkP;
    }     
}
