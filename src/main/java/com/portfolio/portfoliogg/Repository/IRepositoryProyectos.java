
package com.portfolio.portfoliogg.Repository;

import com.portfolio.portfoliogg.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IRepositoryProyectos extends JpaRepository<Proyectos, Integer> {
    
    public Optional<Proyectos> findByNombreProyecto(String nombreProyecto);

    public Boolean existsByNombreProyecto(String nombreProyecto);
}
