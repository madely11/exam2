package ec.edu.espe.examenbetancourt.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RSTurno {
    public String cedula;
    public String nombreCompleto;
    public Integer numeroTurno;
}
