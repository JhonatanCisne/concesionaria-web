package com.proyecto.autos.domain.ports.in;

import com.proyecto.autos.application.dto.AutoCrearDTO;

public interface CrearAutoInputPort{
    void crearAuto(AutoCrearDTO dto);
}