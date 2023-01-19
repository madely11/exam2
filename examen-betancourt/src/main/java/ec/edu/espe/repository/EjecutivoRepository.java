package ec.edu.espe.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.examenbetancourt.model.Ejecutivo;

public interface EjecutivoRepository extends MongoRepository<Ejecutivo, String> {
    
    public Ejecutivo findByCodigoUsuario(Integer codigoUsuario);
}
