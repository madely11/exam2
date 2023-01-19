package ec.edu.espe.examenbetancourt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.examenbetancourt.controller.dto.RSCliente;
import ec.edu.espe.examenbetancourt.controller.mapper.ClienteMapper;
import ec.edu.espe.examenbetancourt.model.Cliente;
import ec.edu.espe.examenbetancourt.service.ClienteService;
import ec.edu.espe.repository.ClienteRepository;

@RestController
@RequestMapping(value = "api/cliente")
public class ClientController {
    private final ClienteRepository clienteRepository;
    private final ClienteService clienteService;

    public ClientController (ClienteRepository clienteRepository, ClienteService clienteService) {
        this.clienteRepository = clienteRepository;
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<RSCliente> obtenerCliente(
        @PathVariable("cedula") String cedula){
        Cliente cliente = clienteService.obtenerClienteGenerarTurno(cedula);
        RSCliente rsClienteBd = ClienteMapper.map(cliente);
        return ResponseEntity.ok(rsClienteBd);
    }
    
}
