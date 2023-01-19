package ec.edu.espe.examenbetancourt.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document(collection = "turnos")
public class Turno {


    @Id
    private String id;

    private Integer numeroTurno;
    private String cedulaCliente;
    private String nombreCliente;
    private String codigoUsuarioEjecutivo;
    private String nombreEjecutivo;
    private LocalDateTime fechaHoraGeneracion;
    private LocalDateTime fechaHoraInicioAtencion;
    private LocalDateTime fechaHoraFinAtencion;
    private Integer calificacion;

    @Version
    private Long version;
}
