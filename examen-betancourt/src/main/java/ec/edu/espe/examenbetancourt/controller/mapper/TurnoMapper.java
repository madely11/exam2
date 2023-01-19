package ec.edu.espe.examenbetancourt.controller.mapper;

import ec.edu.espe.examenbetancourt.controller.dto.RSTurno;
import ec.edu.espe.examenbetancourt.model.Turno;

public class TurnoMapper {
    public static RSTurno mapGeneration(Turno turno){
        return RSTurno.builder()
        .cedula(turno.getCedulaCliente())
        .nombreCompleto(turno.getNombreCliente())
        .numeroTurno(turno.getNumeroTurno())
        .build();
    }
}
