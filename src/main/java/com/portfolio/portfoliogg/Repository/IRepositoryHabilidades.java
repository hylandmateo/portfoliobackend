package com.portfolio.portfoliogg.Repository;

import com.portfolio.portfoliogg.Entity.Habilidades;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryHabilidades extends JpaRepository<Habilidades, Integer> {
    
    public Optional<Habilidades> findByNombreHabilidad(String nombreHabilidad);

    public Boolean existsByNombreHabilidad(String nombreHabilidad);
    
   }
