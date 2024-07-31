package unah.lenguajes.usuariosejercicio.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="usuario")
@Data
public class Usuario {
    
    @Id
    @Column(name="codigousuario") //aqui siempre en minuscula
    private String codigoUsuario;

    private String nombre;

    private String apellido;

    private String departamento;
    
    private String correo;
    
    private String telefono;

    @OneToOne
    @JoinColumn(name="idperfil")
    private Perfil perfil;
}
