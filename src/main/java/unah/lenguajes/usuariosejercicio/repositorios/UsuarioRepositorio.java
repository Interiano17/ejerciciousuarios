package unah.lenguajes.usuariosejercicio.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.usuariosejercicio.modelos.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String>{
    
    public boolean existsByNombre(String nombre);
}
