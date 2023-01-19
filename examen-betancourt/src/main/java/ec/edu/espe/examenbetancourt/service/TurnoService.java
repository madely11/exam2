package ec.edu.espe.examenbetancourt.service;

import ec.edu.espe.examenbetancourt.controller.dto.RSCliente;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import ec.edu.espe.examenbetancourt.model.Ejecutivo;
import ec.edu.espe.examenbetancourt.model.Turno;
import ec.edu.espe.repository.EjecutivoRepository;
import ec.edu.espe.repository.TurnoRepository;

@Service
public class TurnoService {
    private final TurnoRepository turnoRepository;
    private final EjecutivoRepository ejecutivoRepository;

    public TurnoService(TurnoRepository turnoRepository, EjecutivoRepository ejecutivoRepository) {
        this.turnoRepository = turnoRepository;
        this.ejecutivoRepository = ejecutivoRepository;
    }

    public Turno generarTurno(RSCliente rsCliente) {

        List<Turno> listaTurnos = turnoRepository.findAll();
        

        if (listaTurnos.isEmpty()) {
            return Turno.builder()
                    .numeroTurno(1)
                    .nombreCliente(rsCliente.getNombreCompleto())
                    .build();
        } else {
            Turno ultimoTurno = listaTurnos.get(listaTurnos.size() - 1);
            return Turno.builder()
                    .numeroTurno(ultimoTurno.getNumeroTurno() + 1)
                    .nombreCliente(rsCliente.getNombreCompleto())
                    .build();
        }
    }

    public void registroInicioAtencion(Integer numeroTurno, Integer codigoEjecutivo){
        Turno turno = turnoRepository.findByNumeroTurno(numeroTurno);
        Ejecutivo ejecutivo = ejecutivoRepository.findByCodigoUsuario(codigoEjecutivo);
        
        turno.setNombreEjecutivo(ejecutivo.getNombreCompletos());
        turno.setFechaHoraInicioAtencion(LocalDateTime.now());

        try {
            turnoRepository.save(turno);
        } catch (Exception e) {
            throw new RuntimeException("Error registrando la fecha de inicio" +  e);
        }
        turnoRepository.save(turno);
    }

    public void registroFinAtencion(Integer numeroTurno){
        Turno turno = turnoRepository.findByNumeroTurno(numeroTurno);
        turno.setFechaHoraFinAtencion(LocalDateTime.now());
        try {
            turnoRepository.save(turno);
        } catch (Exception e) {
            throw new RuntimeException("Error registrando la fecha de fin" +  e);
        }
        turnoRepository.save(turno);
    }
}


