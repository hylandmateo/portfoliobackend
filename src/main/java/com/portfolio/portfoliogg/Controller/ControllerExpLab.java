
package com.portfolio.portfoliogg.Controller;

import com.portfolio.portfoliogg.Entity.ExperienciaLab;
import com.portfolio.portfoliogg.Service.ServiceExpLab;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "https://portfoliogabg.web.app")
@RequestMapping("/explaboral")
public class ControllerExpLab {

    @Autowired
    ServiceExpLab serviceExpLab;
    
    

   @GetMapping("/listaexplab")
   @ResponseBody
   public List<ExperienciaLab>listaexplab(){
       return serviceExpLab.listaexplab();
   } 
   
   

   @PreAuthorize("hasRole('ADMIN')")
   @PostMapping("/crearexplab")
   public void crearExpLab(@RequestBody ExperienciaLab explab){
    serviceExpLab.crearExpLab(explab);
   }
   
   

   @PreAuthorize("hasRole('ADMIN')")
   @DeleteMapping("/borrarexplab/{id}")
    public void borrarExpLab(@PathVariable int id){
    serviceExpLab.borrarExpLab(id);
    }
    
    

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editarexplab")
    public void editarExpLab(@RequestBody ExperienciaLab explab){
           serviceExpLab.editarExpLab(explab);
    }
    
    

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/buscarexplab/{id}")
    @ResponseBody
    public ExperienciaLab buscarExpLab(@PathVariable int id){
    return serviceExpLab.buscarExpLab(id);
    }
}

