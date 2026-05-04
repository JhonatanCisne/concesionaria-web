package com.proyecto.autos.domain.ports.out;
import com.proyecto.autos.domain.models.Auto;

public interface AutoRepositoryPort {
    void guardar(Auto auto);
    boolean existePorVin(String vin); 
    Auto finById (Long id);
}
