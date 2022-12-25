
package com.portfolio.portfoliogg.Service;

import com.portfolio.portfoliogg.Entity.ModelLibroVisitas;
import com.portfolio.portfoliogg.Repository.IRepositoryLibroVisitas;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServiceLibVis {
    
   @Autowired
   IRepositoryLibroVisitas iRepoLibVis;
   
   
   //ARMA LISTA DE MODELLIBROVISITAS 
    public List <ModelLibroVisitas> listaLibVis(){
        return iRepoLibVis.findAll();
    }
    
    //getOne ES UN METODO DE JPA. 
    //BUSCA POR ID (GETONE) TRAER POR ID (FINDBYID)
    public Optional<ModelLibroVisitas> getOne(int id){
        return iRepoLibVis.findById(id);
    }
    
    //BUSCA POR NOMBRELV
    public Optional <ModelLibroVisitas> getBynombreLV(String nombreLV){
        return iRepoLibVis.findByNombreLV(nombreLV);
    }
    
    //GUARDA NOMBRE Y MSJ EN MODELLIBROVISITAR
    public void guardar(ModelLibroVisitas modLibVis){
        iRepoLibVis.save(modLibVis);
    }
    
    //BORRA POR ID
    public void borrar(int id){
        iRepoLibVis.deleteById(id);
    }
    
    // METODO BOOLEAN PARA SABER SI EXISTE POR ID O NOMBRE
    
    public boolean existsById(int id){
         return iRepoLibVis.existsById(id);
    }
     
    public boolean existsByNombreLV(String nombreLV){
         return iRepoLibVis.existsByNombreLV(nombreLV);
    }
    
    
}