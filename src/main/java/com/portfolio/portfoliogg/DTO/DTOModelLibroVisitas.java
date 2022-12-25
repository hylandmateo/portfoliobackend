
package com.portfolio.portfoliogg.DTO;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DTOModelLibroVisitas {
 
    @NotBlank
    private String nombreLV;
     @NotBlank
    private String mensajeLV;

    public DTOModelLibroVisitas() {
    }

    public DTOModelLibroVisitas(String nombreLV, String mensajeLV) {
        this.nombreLV = nombreLV;
        this.mensajeLV = mensajeLV;
    }

       
}
