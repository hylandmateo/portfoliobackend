
package com.portfolio.portfoliogg.Security.Controller;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MensajeSec {
     private String mensaje;

    public MensajeSec() {
    }

    public MensajeSec(String mensaje) {
        this.mensaje = mensaje;
    }
}
