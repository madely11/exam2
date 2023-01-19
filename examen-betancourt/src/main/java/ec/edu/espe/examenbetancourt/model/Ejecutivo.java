package ec.edu.espe.examenbetancourt.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "ejecutivos")
public class Ejecutivo {
    @Id
    private String id;

    private Integer codigoUsuario;
    private String nombreCompletos;
    private Integer numeroEscritorio;

    @Version
    private Long version;

}
