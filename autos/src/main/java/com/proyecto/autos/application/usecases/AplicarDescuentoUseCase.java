package com.proyecto.autos.application.usecases;

import com.proyecto.autos.application.dto.DescuentoDTO;
import com.proyecto.autos.domain.models.Auto;
import com.proyecto.autos.domain.ports.in.AplicarDescuentoInputPort;
import com.proyecto.autos.domain.ports.out.AutoRepositoryPort;


public class AplicarDescuentoUseCase implements AplicarDescuentoInputPort {
    private final AutoRepositoryPort repositoryPort;

    public AplicarDescuentoUseCase(AutoRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public void aplicarDescuento(DescuentoDTO dto){
        Auto auto = repositoryPort.finById(dto.id());
        auto = auto.aplicarNuevoPrecio(dto.nuevoPrecio());
        repositoryPort.guardar(auto);
    }
}
