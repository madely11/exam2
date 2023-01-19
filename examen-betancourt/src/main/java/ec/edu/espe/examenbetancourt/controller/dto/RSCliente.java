package ec.edu.espe.examenbetancourt.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RSCliente {
    public String cedula;
    public String nombreCompleto;
}
