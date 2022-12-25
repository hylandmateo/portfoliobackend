package com.portfolio.portfoliogg.Controller;

import com.portfolio.portfoliogg.DTO.DTOProyectos;
import com.portfolio.portfoliogg.Entity.Proyectos;
import com.portfolio.portfoliogg.Service.ServiceProyectos;
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
@RequestMapping("/proyectos")
public class ControllerProyectos {

    @Autowired
    ServiceProyectos servProy;
    


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crearproyecto")
    public ResponseEntity<?> crearProyecto(@RequestBody DTOProyectos dtoProyectos) {

        Proyectos proy = new Proyectos(dtoProyectos.getNombreProyecto(), dtoProyectos.getDescripcionProyecto());
        servProy.guardar(proy);

        return new ResponseEntity(new Mensaje("Proyecto guardado"), HttpStatus.OK);
    }
    
    
    

    @GetMapping("/listaproyectos")
    public ResponseEntity<List<Proyectos>> listaProyectos() {
        List<Proyectos> listaProyectos = servProy.listaProyectos();
        return new ResponseEntity(listaProyectos, HttpStatus.OK);

    }
    
    
    

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizarproyecto/{id}")
    public ResponseEntity<?> editarProyecto(@PathVariable("id") int id, @RequestBody Proyectos proyectos) {

        Proyectos proyec = servProy.getOne(id).get();

        proyec.setNombreProyecto(proyectos.getNombreProyecto());

        proyec.setDescripcionProyecto(proyectos.getDescripcionProyecto());

        servProy.guardar(proyec);
        return new ResponseEntity(new Mensaje("Proyecto Actualizado"), HttpStatus.OK);
    }
    
    

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrarproyecto/{id}")
    public ResponseEntity<?> borrarProyecto(@PathVariable("id") int id) {
        if (!servProy.existsById(id)) {
            return new ResponseEntity(new Mensaje("el id no existe"), HttpStatus.BAD_REQUEST);
        }
        servProy.borrar(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
    
    

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id) {
        Proyectos proyec = servProy.getOne(id).get();
        return new ResponseEntity(proyec, HttpStatus.OK);
    }

}
