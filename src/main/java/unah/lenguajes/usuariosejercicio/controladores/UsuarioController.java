package unah.lenguajes.usuariosejercicio.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.usuariosejercicio.modelos.Usuario;
import unah.lenguajes.usuariosejercicio.servicios.UsuarioServicio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/obtener/todos")
    public List<Usuario> obtenerTodos(){
        return this.usuarioServicio.obtenerTodos();
    }

    @PostMapping("/crear")
    public Usuario crearNuevo(@RequestBody Usuario nuevoUsuario){
        return this.usuarioServicio.crearNuevo(nuevoUsuario);
    }

    @GetMapping("/buscar/{codigoUsuario}")
    public Usuario buscarPorCodigo(@PathVariable String codigoUsuario){
        return this.usuarioServicio.buscarPorCodigo(codigoUsuario);
    }
    
    @DeleteMapping("/eliminar/{codigoUsuario}")
    public String eliminarPorCodigo(@PathVariable String codigoUsuario){
        return this.usuarioServicio.eliminarPorCodigo(codigoUsuario);
    }

    @PutMapping("actualizar/{codigoUsuario}")
    public Usuario actualizar(@PathVariable String codigoUsuario, @RequestBody Usuario usuario) {
        return this.usuarioServicio.actualizar(codigoUsuario, usuario);
    }
}
