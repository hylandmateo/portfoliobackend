package com.portfolio.portfoliogg.Controller;

import com.portfolio.portfoliogg.Entity.Habilidades;
import com.portfolio.portfoliogg.Service.ServiceHabilidades;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://portfoliogabg.web.app")
@RequestMapping("/habilidades")
public class ControllerHabilidades {

    @Autowired
    ServiceHabilidades servHab;

    

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crearhabilidad")
    public ResponseEntity<?> crearHabilidad(@RequestBody Habilidades habilidades) {

        Habilidades habil = new Habilidades(habilidades.getNombreHabilidad(), habilidades.getDescripcionHabilidad());
        servHab.guardar(habil);

        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);
    }
    
    
    

    @GetMapping("/listahabilidades")
    public ResponseEntity<List<Habilidades>> listaHabilidades() {
        List<Habilidades> listaHabilidades = servHab.listaHabilidades();
        return new ResponseEntity(listaHabilidades, HttpStatus.OK);

    }
    

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizarhabilidad/{id}")
    public ResponseEntity<?> editarHabilidad(@PathVariable("id") int id, @RequestBody Habilidades habilidades) {

        Habilidades habil = servHab.getOne(id).get();

        habil.setNombreHabilidad(habilidades.getNombreHabilidad());

        habil.setDescripcionHabilidad(habilidades.getDescripcionHabilidad());

        servHab.guardar(habil);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
    }
    
    
    

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrarhabilidad/{id}")
    public ResponseEntity<?> borrarHabilidad(@PathVariable("id") int id) {
        if (!servHab.existsById(id)) {
            return new ResponseEntity(new Mensaje("el id no existe"), HttpStatus.BAD_REQUEST);
        }
        servHab.borrar(id);
        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }
    
    

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidades> getById(@PathVariable("id") int id) {
        Habilidades habil = servHab.getOne(id).get();
        return new ResponseEntity(habil, HttpStatus.OK);
    }

}
