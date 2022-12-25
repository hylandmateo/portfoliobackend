package com.portfolio.portfoliogg.Service;

import com.portfolio.portfoliogg.Entity.Habilidades;
import com.portfolio.portfoliogg.Repository.IRepositoryHabilidades;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServiceHabilidades {
    
    @Autowired 
    IRepositoryHabilidades iRepoHab;
    
    
    public List<Habilidades> listaHabilidades(){
        return iRepoHab.findAll();
    }
   
    public Optional<Habilidades> getOne(int id){
        return iRepoHab.findById(id);
    }
    
   
    public Optional <Habilidades> getBynombreHabilidad(String nombreHabilidad){
        return iRepoHab.findByNombreHabilidad(nombreHabilidad);
    }
    
    
    public void guardar(Habilidades habilidades){
        iRepoHab.save(habilidades);
    }
    
  
    public void borrar(int id){
        iRepoHab.deleteById(id);
    }
    
    
    public boolean existsById(int id){
         return iRepoHab.existsById(id);
    }
     
    public boolean existsByNombreHabilidad(String nombreHabilidad){
         return iRepoHab.existsByNombreHabilidad(nombreHabilidad);
    }
    
    
}
