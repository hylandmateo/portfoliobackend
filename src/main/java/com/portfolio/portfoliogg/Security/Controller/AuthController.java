
package com.portfolio.portfoliogg.Security.Controller;

import com.portfolio.portfoliogg.Security.Dto.JwtDto;
import com.portfolio.portfoliogg.Security.Dto.LoginUsuario;
import com.portfolio.portfoliogg.Security.Dto.NuevoUsuario;
import com.portfolio.portfoliogg.Security.Entity.Rol;
import com.portfolio.portfoliogg.Security.Entity.Usuario;
import com.portfolio.portfoliogg.Security.Enums.RolTipo;
import com.portfolio.portfoliogg.Security.MainSecurity;
import com.portfolio.portfoliogg.Security.Service.RolService;
import com.portfolio.portfoliogg.Security.Service.UsuarioService;
import com.portfolio.portfoliogg.Security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.security.crypto.password.PasswordEncoder;


@RestController
@RequestMapping("/authentication")
@CrossOrigin(origins = "https://portfoliogabg.web.app")
@ComponentScan(basePackageClasses = MainSecurity.class)
public class AuthController {
   
    @Autowired 
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/nuevo")    
    public ResponseEntity<?> nuevoUsuario(@Valid @RequestBody  NuevoUsuario nuevoUsuario,
                                          BindingResult bindingResult){
        
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(new MensajeSec("Campos mal ingresados"), HttpStatus.BAD_REQUEST);
        }
        if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario())){
            return new ResponseEntity<>(new MensajeSec("Ese usuario ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail())){
            return new ResponseEntity<>(new MensajeSec("Ese email ya existe"), HttpStatus.BAD_REQUEST);
        }
       
        Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(),
                nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));

        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolTipo(RolTipo.ROLE_USER).get());
        
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolTipo(RolTipo.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);

        return new ResponseEntity<>(new MensajeSec("Usuario creado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity(new MensajeSec("Campos mal ingresados"), HttpStatus.BAD_REQUEST);
        
        Authentication authentication = authenticationManager.authenticate(                
        new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));       
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity<>(jwtDto, HttpStatus.OK);
    }
    
    
}