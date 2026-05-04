package com.proyecto.autos.infrastructure.adapters.out.entities;
import com.proyecto.autos.domain.models.EnumEstado;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "productos")
@Getter
@Setter
@NoArgsConstructor
public class AutoEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String vin;
    private Double precio;
    private Integer anio;
    private Double impuesto;
    @Enumerated(EnumType.STRING)
    private EnumEstado estado;

    public AutoEntity(String nombre, String vin, Double precio, Integer anio, Double impuesto, EnumEstado estado) { 
        this.nombre = nombre;
        this.vin = vin;
        this.precio = precio;
        this.anio = anio;
        this.impuesto = impuesto;
        this.estado = estado;
    }
}
