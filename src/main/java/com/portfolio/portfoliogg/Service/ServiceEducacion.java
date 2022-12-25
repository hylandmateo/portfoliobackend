package com.portfolio.portfoliogg.Service;

import com.portfolio.portfoliogg.Entity.Educacion;
import com.portfolio.portfoliogg.Repository.IRepositoryEducacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServiceEducacion {
    
      @Autowired
      IRepositoryEducacion irepoEdu;
      
 
    public List <Educacion> listaEducacion(){
        return irepoEdu.findAll();
    }
    
   
    public Optional<Educacion> getOne(int id){
        return irepoEdu.findById(id);
    }
    
   
    public Optional <Educacion> getBynombreEducacion(String nombreEducacion){
        return irepoEdu.findByNombreEducacion(nombreEducacion);
    }
    
  
    public void guardar(Educacion educacion){
        irepoEdu.save(educacion);
    }
    

    public void borrar(int id){
        irepoEdu.deleteById(id);
    }
    

    
    public boolean existsById(int id){
         return irepoEdu.existsById(id);
    }
     
    public boolean existsByNombreEducacion(String nombreEducacion){
         return irepoEdu.existsByNombreEducacion(nombreEducacion);
    }
}
