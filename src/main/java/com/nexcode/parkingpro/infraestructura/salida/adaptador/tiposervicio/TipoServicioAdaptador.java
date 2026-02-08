package com.nexcode.parkingpro.infraestructura.salida.adaptador.tiposervicio;

import com.nexcode.parkingpro.dominio.modelo.TipoServicio;
import com.nexcode.parkingpro.dominio.puertos.tiposervicio.TipoServicioPersistencia;
import com.nexcode.parkingpro.infraestructura.salida.persistencia.tiposervicio.TipoServicioRepositorio;
import com.nexcode.parkingpro.infraestructura.salida.mapeador.tiposervicio.TipoServicioMapeador;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TipoServicioAdaptador implements TipoServicioPersistencia {

    private final TipoServicioRepositorio repositorio;
    private final TipoServicioMapeador mapeador;

    @Override
    public TipoServicio guardar(TipoServicio modelo) {
        return this.mapeador.aDominio(this.repositorio.save(
            this.mapeador.aEntidad(modelo)));
    }

    @Override
    public TipoServicio buscarPorId(Long id) {
        return repositorio.findById(id).map(mapeador::aDominio).orElse(null);
    }

    @Override
    public List<TipoServicio> listarTodo() {
        return repositorio.findAll().stream().map(mapeador::aDominio).toList();
    }

    @Override
    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public void actualizar(TipoServicio modelo) {
        repositorio.save(
        mapeador.aEntidad(modelo));
    }

    @Override
    public void guardar(List<TipoServicio> tiposervicio) {
        this.repositorio.saveAll(this.mapeador.aEntidad(tiposervicio));
    }
}
