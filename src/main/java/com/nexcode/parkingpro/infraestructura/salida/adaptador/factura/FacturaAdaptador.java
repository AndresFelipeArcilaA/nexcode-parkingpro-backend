package com.nexcode.parkingpro.infraestructura.salida.adaptador.factura;

import com.nexcode.parkingpro.dominio.modelo.Factura;
import com.nexcode.parkingpro.dominio.puertos.factura.FacturaPersistencia;
import com.nexcode.parkingpro.infraestructura.salida.persistencia.factura.FacturaRepositorio;
import com.nexcode.parkingpro.infraestructura.salida.mapeador.factura.FacturaMapeador;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FacturaAdaptador implements FacturaPersistencia {

    private final FacturaRepositorio repositorio;
    private final FacturaMapeador mapeador;

    @Override
    public Factura guardar(Factura modelo) {
        return this.mapeador.aDominio(this.repositorio.save(
            this.mapeador.aEntidad(modelo)));
    }

    @Override
    public Factura buscarPorId(Long id) {
        return repositorio.findById(id).map(mapeador::aDominio).orElse(null);
    }

    @Override
    public List<Factura> listarTodo() {
        return repositorio.findAll().stream().map(mapeador::aDominio).toList();
    }

    @Override
    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public void actualizar(Factura modelo) {
        repositorio.save(
        mapeador.aEntidad(modelo));
    }
}
