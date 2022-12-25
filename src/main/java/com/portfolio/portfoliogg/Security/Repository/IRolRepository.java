
package com.portfolio.portfoliogg.Security.Repository;

import com.portfolio.portfoliogg.Security.Entity.Rol;
import com.portfolio.portfoliogg.Security.Enums.RolTipo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer>{
    
    Optional<Rol> findByRolTipo(RolTipo rolTipo);
    
}