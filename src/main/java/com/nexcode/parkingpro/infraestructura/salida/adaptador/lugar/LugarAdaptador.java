package com.nexcode.parkingpro.infraestructura.salida.adaptador.lugar;

import com.nexcode.parkingpro.dominio.modelo.Lugar;
import com.nexcode.parkingpro.dominio.puertos.lugar.LugarPersistencia;
import com.nexcode.parkingpro.infraestructura.salida.persistencia.lugar.LugarRepositorio;
import com.nexcode.parkingpro.infraestructura.salida.mapeador.lugar.LugarMapeador;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LugarAdaptador implements LugarPersistencia {

    private final LugarRepositorio repositorio;
    private final LugarMapeador mapeador;

    @Override
    public Lugar guardar(Lugar modelo) {
        return this.mapeador.aDominio(this.repositorio.save(
            this.mapeador.aEntidad(modelo)));
    }

    @Override
    public Lugar buscarPorId(Long id) {
        return repositorio.findById(id).map(mapeador::aDominio).orElse(null);
    }

    @Override
    public List<Lugar> listarTodo() {
        return repositorio.findAll().stream().map(mapeador::aDominio).toList();
    }

    @Override
    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public void actualizar(Lugar modelo) {
        repositorio.save(
        mapeador.aEntidad(modelo));
    }
}
