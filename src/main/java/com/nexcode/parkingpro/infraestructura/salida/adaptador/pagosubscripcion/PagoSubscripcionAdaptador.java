package com.nexcode.parkingpro.infraestructura.salida.adaptador.pagosubscripcion;

import com.nexcode.parkingpro.dominio.modelo.PagoSubscripcion;
import com.nexcode.parkingpro.dominio.puertos.pagosubscripcion.PagoSubscripcionPersistencia;
import com.nexcode.parkingpro.infraestructura.salida.persistencia.pagosubscripcion.PagoSubscripcionRepositorio;
import com.nexcode.parkingpro.infraestructura.salida.mapeador.pagosubscripcion.PagoSubscripcionMapeador;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PagoSubscripcionAdaptador implements PagoSubscripcionPersistencia {

    private final PagoSubscripcionRepositorio repositorio;
    private final PagoSubscripcionMapeador mapeador;

    @Override
    public PagoSubscripcion guardar(PagoSubscripcion modelo) {
        return this.mapeador.aDominio(this.repositorio.save(
            this.mapeador.aEntidad(modelo)));
    }

    @Override
    public PagoSubscripcion buscarPorId(Long id) {
        return repositorio.findById(id).map(mapeador::aDominio).orElse(null);
    }

    @Override
    public List<PagoSubscripcion> listarTodo() {
        return repositorio.findAll().stream().map(mapeador::aDominio).toList();
    }

    @Override
    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public void actualizar(PagoSubscripcion modelo) {
        repositorio.save(
        mapeador.aEntidad(modelo));
    }
}
