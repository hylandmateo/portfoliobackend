
package com.portfolio.portfoliogg.Service;

import com.portfolio.portfoliogg.Entity.ExperienciaLab;
import com.portfolio.portfoliogg.Repository.IRepositoryExpeLab;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServiceExpLab implements IExpLabService {
    
    @Autowired
    IRepositoryExpeLab irepoexplab;

    @Override
    public List<ExperienciaLab> listaexplab() {
      return irepoexplab.findAll();
    }

    @Override
    public void crearExpLab(ExperienciaLab explab) {
        irepoexplab.save(explab);
    }

    @Override
    public void borrarExpLab(int id) {
       irepoexplab.deleteById(id);
    }

    @Override
    public void editarExpLab(ExperienciaLab explab) {
      irepoexplab.save(explab);
    }

    @Override
    public ExperienciaLab buscarExpLab(int id) {
       return irepoexplab.findById(id).orElse(null);       
    }

  
}
