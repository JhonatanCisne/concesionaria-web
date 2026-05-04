package com.proyecto.autos.domain.ports.in;

import com.proyecto.autos.application.dto.DescuentoDTO;

public interface AplicarDescuentoInputPort {
    void aplicarDescuento(DescuentoDTO dto);
}