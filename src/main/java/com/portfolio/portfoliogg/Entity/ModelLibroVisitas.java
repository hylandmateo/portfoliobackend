
package com.portfolio.portfoliogg.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class ModelLibroVisitas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreLV;
    private String mensajeLV;

    public ModelLibroVisitas() {
    }

    public ModelLibroVisitas(String nombreLV, String mensajeLV) {
        this.nombreLV = nombreLV;
        this.mensajeLV = mensajeLV;
    }
    
    
    
}
