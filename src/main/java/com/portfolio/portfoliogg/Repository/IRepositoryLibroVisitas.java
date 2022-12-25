package com.portfolio.portfoliogg.Repository;

import com.portfolio.portfoliogg.Entity.ModelLibroVisitas;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryLibroVisitas extends JpaRepository<ModelLibroVisitas, Integer> {

    public Optional<ModelLibroVisitas> findByNombreLV(String nombreLV);

    public Boolean existsByNombreLV(String nombreLV);

}
