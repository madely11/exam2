package ec.edu.espe.examenbetancourt.controller.mapper;

import ec.edu.espe.examenbetancourt.controller.dto.RSCliente;
import ec.edu.espe.examenbetancourt.model.Cliente;

public class ClienteMapper {
    public static RSCliente map(Cliente cliente){
        String nombrecompleto = cliente.getNombres() + " " + cliente.getApellidos();
        return RSCliente.builder()
        .cedula(cliente.getCedula())
        .nombreCompleto(nombrecompleto)
        .build();
                
    }
}
