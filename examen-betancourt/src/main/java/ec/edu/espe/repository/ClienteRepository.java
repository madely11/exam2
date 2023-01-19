package ec.edu.espe.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.examenbetancourt.model.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String>{
    public Cliente findByCedula(String cedula);
}
