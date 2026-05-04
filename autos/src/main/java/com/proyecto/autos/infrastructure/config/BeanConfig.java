package com.proyecto.autos.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.proyecto.autos.application.usecases.AplicarDescuentoUseCase;
import com.proyecto.autos.application.usecases.CrearAutoUseCase;
import com.proyecto.autos.domain.ports.in.AplicarDescuentoInputPort;
import com.proyecto.autos.domain.ports.in.CrearAutoInputPort;
import com.proyecto.autos.domain.ports.out.AutoRepositoryPort;

@Configuration
public class BeanConfig {

    @Bean
    public CrearAutoInputPort crearAutoUseCase(AutoRepositoryPort autoRepositoryPort) {
        return new CrearAutoUseCase(autoRepositoryPort);
    }
    @Bean
    public AplicarDescuentoInputPort aplicarDesacuentoInputPort(AutoRepositoryPort autoRepositoryPort){
        return new AplicarDescuentoUseCase(autoRepositoryPort);
    }
}