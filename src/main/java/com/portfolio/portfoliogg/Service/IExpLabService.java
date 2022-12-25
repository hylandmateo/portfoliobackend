
package com.portfolio.portfoliogg.Service;

import com.portfolio.portfoliogg.Entity.ExperienciaLab;
import java.util.List;



public interface IExpLabService {
    
    public List<ExperienciaLab> listaexplab(); 
    public void crearExpLab (ExperienciaLab explab);
    public void borrarExpLab(int id);
    public void editarExpLab(ExperienciaLab explab);
    public ExperienciaLab buscarExpLab(int id);
}
