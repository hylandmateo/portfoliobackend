package com.portfolio.portfoliogg.Repository;
import com.portfolio.portfoliogg.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryEducacion extends JpaRepository<Educacion, Integer>{
    
     public Optional<Educacion> findByNombreEducacion(String nombreEducacion);

    public Boolean existsByNombreEducacion(String nombreEducacion);
    
}
