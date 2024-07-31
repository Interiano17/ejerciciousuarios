package unah.lenguajes.usuariosejercicio.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="perfil")
@Data
public class Perfil {
    
    @Id
    @Column(name="idperfil") //aqui siempre en minuscula
    private long idPerfil;

    private String rol;

    private String descripcion;

    @JsonIgnore
    @OneToOne(mappedBy="perfil", cascade= CascadeType.ALL)
    private Usuario usuario;
}
