
package com.portfolio.rn.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreSk;
    private String imagenSk;
    private String PercentSk;

    public Skills() {
    }
    
    public Skills(String nombreSk, String imagenSk, String PercentSk) {
        this.nombreSk = nombreSk;
        this.imagenSk = imagenSk;
        this.PercentSk = PercentSk;
    }    
}
