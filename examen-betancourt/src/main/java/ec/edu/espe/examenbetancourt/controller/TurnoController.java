package ec.edu.espe.examenbetancourt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.examenbetancourt.controller.dto.RSCliente;
import ec.edu.espe.examenbetancourt.controller.dto.RSTurno;
import ec.edu.espe.examenbetancourt.controller.mapper.TurnoMapper;
import ec.edu.espe.examenbetancourt.model.Turno;
import ec.edu.espe.examenbetancourt.service.TurnoService;
import ec.edu.espe.repository.TurnoRepository;

@RestController
@RequestMapping(value = "api/cliente")
public class TurnoController {
    private final TurnoRepository turnoRepository;
    private final TurnoService turnoService;
    
    public TurnoController (TurnoRepository turnoRepository, TurnoService turnoService) {
        this.turnoRepository = turnoRepository;
        this.turnoService = turnoService;
    }

    @PostMapping
    public ResponseEntity<RSTurno> generarTurno( 
        @RequestBody RSCliente rsCliente){
            Turno turno = turnoService.generarTurno(rsCliente);
            RSTurno rsTurnoBd = TurnoMapper.mapGeneration(turno);
            return ResponseEntity.ok(rsTurnoBd);
    }

    @PutMapping(value = "/atenderTurno/{numeroTurno}/{codigoEjecutivo}")
    public ResponseEntity<Void> atenderTurno(
        @PathVariable("numeroTurno") Integer numeroTurno,
        @PathVariable("codigoEjecutivo") Integer codigoEjecutivo){
            turnoService.registroInicioAtencion(numeroTurno, codigoEjecutivo);
            return ResponseEntity.ok().build();
    }

    



    
}
