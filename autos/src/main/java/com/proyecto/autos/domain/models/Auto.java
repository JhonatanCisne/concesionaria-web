package com.proyecto.autos.domain.models;
import java.time.Year;
import java.util.Objects;

public record Auto(
    Long id, 
    String nombre,
    String vin,
    Double precio,
    Integer anio,
    Double impuesto,
    EnumEstado estado
    ) {
        public Auto {
            Objects.requireNonNull(nombre,  "El nombre no puede ser null");
            Objects.requireNonNull(vin,     "El vin no puede ser null");
            Objects.requireNonNull(precio,  "El precio no puede ser null");
            Objects.requireNonNull(anio,    "El anio no puede ser null");

            if(precio<=0){
                throw new IllegalArgumentException("El precio del vehiculo no puede ser inferior a 0"); 
            }
            if(anio>Year.now().getValue() || anio<1886){
                throw new IllegalArgumentException("El año del vehiculo debe estar entre el rango de 1886 a "+Year.now().getValue()); 
            }
        }
        public Auto aplicarNuevoPrecio(Double nuevoPrecio) {
            return new Auto(
                this.id, 
                this.nombre, 
                this.vin, 
                nuevoPrecio, 
                this.anio, 
                calcularImpuesto(nuevoPrecio), 
                this.estado
            );
        }
        public static Double calcularImpuesto(Double precio){
            return (precio>5000)?precio*0.15:0;
        }
        public static EnumEstado estadoInicial(){
            return EnumEstado.DISPONIBLE;
        }

    }