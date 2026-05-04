package com.proyecto.autos.infrastructure.adapters.out;

import org.springframework.stereotype.Component;

import com.proyecto.autos.domain.models.Auto;
import com.proyecto.autos.domain.ports.out.AutoRepositoryPort;
import com.proyecto.autos.infrastructure.adapters.out.entities.AutoEntity;


@Component
public class JpaAutoAdapter implements AutoRepositoryPort {
    private final MyJpaRepository jpaRepository;

    public JpaAutoAdapter(MyJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void guardar(Auto auto) {
        AutoEntity entity = new AutoEntity(auto.nombre(), auto.vin(), auto.precio(), auto.anio(), auto.impuesto(), auto.estado());
        if (auto.id() != null) {
            entity.setId(auto.id());
        }
        jpaRepository.save(entity);
    }

    @Override
    public boolean existePorVin(String vin) {
        return jpaRepository.existsByVin(vin); 
    }

    @Override
    public Auto finById(Long id) {
        return jpaRepository.findById(id)
            .map(entity -> new Auto(
                entity.getId(),
                entity.getNombre(), 
                entity.getVin(), 
                entity.getPrecio(), 
                entity.getAnio(), 
                entity.getImpuesto(), 
                entity.getEstado()
            )) 
            .orElseThrow(() -> new RuntimeException("No encontrado"));
    }
    
}

interface MyJpaRepository extends org.springframework.data.jpa.repository.JpaRepository<AutoEntity, Long> {
    boolean existsByVin(String vin);
}
