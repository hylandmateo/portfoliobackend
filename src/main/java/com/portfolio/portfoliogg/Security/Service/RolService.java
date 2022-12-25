
package com.portfolio.portfoliogg.Security.Service;

import com.portfolio.portfoliogg.Security.Entity.Rol;
import com.portfolio.portfoliogg.Security.Enums.RolTipo;
import com.portfolio.portfoliogg.Security.Repository.IRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional // Mantiene persistencia de los datos
public class RolService {
     
    
    @Autowired
    IRolRepository irolRepository;

    public Optional<Rol> getByRolTipo(RolTipo rolTipo){
        return  irolRepository.findByRolTipo(rolTipo);
    }

    public void save(Rol rol){
        irolRepository.save(rol);
    }
}