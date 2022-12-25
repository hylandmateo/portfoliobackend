package com.portfolio.portfoliogg.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEducacion;
    private String fechaEducacion;
    private String descripcionEducacion;

    public Educacion() {
    }

    public Educacion(String nombreEducacion, String fechaEducacion, String descripcionEducacion) {
        this.nombreEducacion = nombreEducacion;
        this.fechaEducacion = fechaEducacion;
        this.descripcionEducacion = descripcionEducacion;
    }

    

}
