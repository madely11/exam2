package ec.edu.espe.examenbetancourt.service;

import org.springframework.stereotype.Service;

import ec.edu.espe.examenbetancourt.controller.dto.RSCliente;
import ec.edu.espe.examenbetancourt.model.Cliente;
import ec.edu.espe.repository.ClienteRepository;

@Service
public class ClienteService {
    
    private final ClienteRepository clienteRepository;

    public ClienteService (ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente obtenerClienteGenerarTurno (String cedula){
        Cliente cliente = clienteRepository.findByCedula(cedula);
        return cliente;
    }
}
