package com.proyecto.autos.application.usecases;

import com.proyecto.autos.application.dto.AutoCrearDTO;
import com.proyecto.autos.domain.models.Auto;
import com.proyecto.autos.domain.ports.in.CrearAutoInputPort;
import com.proyecto.autos.domain.ports.out.AutoRepositoryPort;


public class CrearAutoUseCase implements CrearAutoInputPort{
    private final AutoRepositoryPort repositoryPort;

    public CrearAutoUseCase(AutoRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }
    
    @Override
    public void crearAuto(AutoCrearDTO dto) {
        if(repositoryPort.existePorVin(dto.vin())){
            throw new RuntimeException("El VIN " + dto.vin() + " ya está registrado");
        }
        Auto auto = new Auto(
            null, 
            dto.nombre(),
            dto.vin(),
            dto.precio(),
            dto.anio(),
            Auto.calcularImpuesto(dto.precio()),
            Auto.estadoInicial());
        repositoryPort.guardar(auto);
    }
}