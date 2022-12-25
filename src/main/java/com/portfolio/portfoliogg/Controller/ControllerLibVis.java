package com.portfolio.portfoliogg.Controller;

import com.portfolio.portfoliogg.DTO.DTOModelLibroVisitas;
import com.portfolio.portfoliogg.Entity.ModelLibroVisitas;
import com.portfolio.portfoliogg.Service.ServiceLibVis;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/librovisitas")
public class ControllerLibVis {

    @Autowired
    ServiceLibVis serviceLibVis;
    
    

    @GetMapping("/listalibvis")
    public ResponseEntity<List<ModelLibroVisitas>> listaLibVis() {
        List<ModelLibroVisitas> listaLibVis = serviceLibVis.listaLibVis();
        return new ResponseEntity(listaLibVis, HttpStatus.OK);
    }
    

    //UTILIZA DTOModelLibroVisitas

    @PostMapping("/crearmensaje")
    public ResponseEntity<?> crearMensaje(@RequestBody DTOModelLibroVisitas dtoModLibVis) {
        if (StringUtils.isBlank(dtoModLibVis.getNombreLV())) {
            return new ResponseEntity(new Mensaje("Es necesario ingresar un nombre"), HttpStatus.BAD_REQUEST);
        }

        if (serviceLibVis.existsByNombreLV(dtoModLibVis.getNombreLV())) {
            return new ResponseEntity(new Mensaje("Ese nombre existe"), HttpStatus.BAD_REQUEST);
        }

        ModelLibroVisitas modLibVis = new ModelLibroVisitas(dtoModLibVis.getNombreLV(), dtoModLibVis.getMensajeLV());
        serviceLibVis.guardar(modLibVis);

        return new ResponseEntity(new Mensaje("Mensaje guardado"), HttpStatus.OK);
    }


        @PutMapping("/actualizarlibrovis/{id}")
        public ResponseEntity<?> editarLV(@PathVariable("id") int id, @RequestBody DTOModelLibroVisitas dtoModLibVis) {

        // VALIDAR SI EXISTE EL ID
        if (!serviceLibVis.existsById(id)) {
            return new ResponseEntity(new Mensaje("el id no existe"), HttpStatus.BAD_REQUEST);
        }

        //CAMPO OBLIGATORIO
        if (StringUtils.isBlank(dtoModLibVis.getNombreLV())) {
            return new ResponseEntity(new Mensaje("El nombre es necesario"), HttpStatus.BAD_REQUEST);
        }

        ModelLibroVisitas modLibVis = serviceLibVis.getOne(id).get();

        //SI PASA VALIDACIONES SETEA nombreLV y mensajeLV
        modLibVis.setNombreLV(dtoModLibVis.getNombreLV());

        modLibVis.setMensajeLV(dtoModLibVis.getMensajeLV());

        serviceLibVis.guardar(modLibVis);
        return new ResponseEntity(new Mensaje("Libro de firmas actualizado"), HttpStatus.OK);
    }
        
        

    @DeleteMapping("/borrarlibvis/{id}")
    public ResponseEntity<?> borrarLibVis(@PathVariable("id") int id) {
        if (!serviceLibVis.existsById(id)) {
            return new ResponseEntity(new Mensaje("el id no existe"), HttpStatus.BAD_REQUEST);
        }
        serviceLibVis.borrar(id);
        return new ResponseEntity(new Mensaje("Mensaje eliminado"), HttpStatus.OK);
    }
    
    

    @GetMapping("/actualizarporid/{id}")
    public ResponseEntity<ModelLibroVisitas>actualizarPorId(@PathVariable("id")  int id){
    
    if(!serviceLibVis.existsById(id)){
      return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);  
    }
    ModelLibroVisitas modLibVis = serviceLibVis.getOne(id).get();
    return new ResponseEntity(modLibVis, HttpStatus.OK);
    }
}
