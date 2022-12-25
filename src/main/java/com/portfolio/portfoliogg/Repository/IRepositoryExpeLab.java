
package com.portfolio.portfoliogg.Repository;

import com.portfolio.portfoliogg.Entity.ExperienciaLab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryExpeLab extends JpaRepository <ExperienciaLab, Integer>{
    
   
}
