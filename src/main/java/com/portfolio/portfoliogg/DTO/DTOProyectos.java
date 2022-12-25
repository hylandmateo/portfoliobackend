
package com.portfolio.portfoliogg.DTO;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DTOProyectos {
    
    @NotBlank
    private String nombreProyecto;
    @NotBlank
    private String descripcionProyecto;

    public DTOProyectos() {
    }

    public DTOProyectos(String nombreProyecto, String descripcionProyecto) {
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
    }

   
  
    
}
