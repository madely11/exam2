package ec.edu.espe.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.examenbetancourt.model.Turno;

public interface TurnoRepository extends MongoRepository<Turno, String> {

    public List<Turno> findAll();
    public Turno findByNumeroTurno(Integer numeroTurno);
    public Turno save(Turno turno);

}
