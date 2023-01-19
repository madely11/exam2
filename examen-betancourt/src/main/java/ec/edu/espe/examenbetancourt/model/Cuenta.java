package ec.edu.espe.examenbetancourt.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cuenta {
    private String numeroCuenta;
    private String tipoCuenta;
    private BigDecimal saldoPromedio;
}
