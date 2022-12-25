
package com.portfolio.portfoliogg.Service;

import com.portfolio.portfoliogg.Entity.Proyectos;
import com.portfolio.portfoliogg.Repository.IRepositoryProyectos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServiceProyectos {
    
    @Autowired
 
    IRepositoryProyectos iRepoProy;
    
  
    public List<Proyectos> listaProyectos(){
        return iRepoProy.findAll();
    }
   
    public Optional<Proyectos> getOne(int id){
        return iRepoProy.findById(id);
    }
    
   
    public Optional <Proyectos> getBynombreProyecto(String nombreProyecto){
        return iRepoProy.findByNombreProyecto(nombreProyecto);
    }
    
    
    public void guardar(Proyectos proyectos){
        iRepoProy.save(proyectos);
    }
    
  
    public void borrar(int id){
        iRepoProy.deleteById(id);
    }
    
    
    public boolean existsById(int id){
         return iRepoProy.existsById(id);
    }
     
    public boolean existsByNombreProyecto(String nombreProyecto){
         return iRepoProy.existsByNombreProyecto(nombreProyecto);
    }
    
    
}
