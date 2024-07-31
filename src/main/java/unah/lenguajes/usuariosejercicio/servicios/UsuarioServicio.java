package unah.lenguajes.usuariosejercicio.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.usuariosejercicio.modelos.Usuario;
import unah.lenguajes.usuariosejercicio.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicio {
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> obtenerTodos(){
        return this.usuarioRepositorio.findAll();
    }

    public Usuario crearNuevo(Usuario nuevoUsuario){
        return this.usuarioRepositorio.save(nuevoUsuario);
    }

    public Usuario buscarPorCodigo(String codigoUsuario){
        return this.usuarioRepositorio.findById(codigoUsuario).get();
    }

    public String eliminarPorCodigo(String codigoUsuario){
        if(this.usuarioRepositorio.existsById(codigoUsuario)){
            this.usuarioRepositorio.deleteById(codigoUsuario);
            return "Se ha eliminado el registro.";
        }
        return "No existe el registro.";
    }

    public Usuario actualizar(String codigoUsuario, Usuario usuario){
        if(this.usuarioRepositorio.existsById(codigoUsuario)){
            Usuario usuarioActualizar = this.usuarioRepositorio.findById(codigoUsuario).get();
            usuarioActualizar.setNombre(usuario.getNombre());
            usuarioActualizar.setApellido(usuario.getApellido());
            usuarioActualizar.setDepartamento(usuario.getDepartamento());
            usuarioActualizar.setCorreo(usuario.getCorreo());
            usuarioActualizar.setTelefono(usuario.getTelefono());
            //usuarioActualizar.setIdPerfil(usuario.getIdPerfil());
            this.usuarioRepositorio.save(usuarioActualizar);

            return usuarioActualizar;
        }
        return null;
    }
}
