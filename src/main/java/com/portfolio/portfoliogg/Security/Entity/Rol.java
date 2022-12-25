
package com.portfolio.portfoliogg.Security.Entity;

import com.portfolio.portfoliogg.Security.Enums.RolTipo;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Rol {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private RolTipo rolTipo;

    
    public Rol() {
    }

    public Rol(RolTipo rolTipo) {
      this.rolTipo = rolTipo;
    }

   

}