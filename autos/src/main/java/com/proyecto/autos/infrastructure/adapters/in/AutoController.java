package com.proyecto.autos.infrastructure.adapters.in;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.autos.application.dto.AutoCrearDTO;
import com.proyecto.autos.application.dto.DescuentoDTO;
import com.proyecto.autos.domain.ports.in.AplicarDescuentoInputPort;
import com.proyecto.autos.domain.ports.in.CrearAutoInputPort;

@RestController
@RequestMapping("/api/productos")
public class AutoController {
    private final CrearAutoInputPort inputPortCrear;
    private final AplicarDescuentoInputPort inputPortDescuento;

    public AutoController(CrearAutoInputPort inputPortCrear, AplicarDescuentoInputPort inputPortDescuento) {
        this.inputPortCrear = inputPortCrear;
        this.inputPortDescuento = inputPortDescuento;
    }

    @PostMapping("/crear")
    public void crear(@RequestBody AutoCrearDTO dto) {
        inputPortCrear.crearAuto(dto);
    }

    @PostMapping("/descontar")
    public void descontar(@RequestBody DescuentoDTO dto){
        inputPortDescuento.aplicarDescuento(dto);
    }
}