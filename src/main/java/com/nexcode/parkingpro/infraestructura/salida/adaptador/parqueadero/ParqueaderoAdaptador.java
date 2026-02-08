package com.nexcode.parkingpro.infraestructura.salida.adaptador.parqueadero;

import com.nexcode.parkingpro.dominio.modelo.Parqueadero;
import com.nexcode.parkingpro.dominio.puertos.parqueadero.ParqueaderoPersistencia;
import com.nexcode.parkingpro.infraestructura.salida.persistencia.parqueadero.ParqueaderoRepositorio;
import com.nexcode.parkingpro.infraestructura.salida.mapeador.parqueadero.ParqueaderoMapeador;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ParqueaderoAdaptador implements ParqueaderoPersistencia {

    private final ParqueaderoRepositorio repositorio;
    private final ParqueaderoMapeador mapeador;

    @Override
    public Parqueadero guardar(Parqueadero modelo) {
        return this.mapeador.aDominio(this.repositorio.save(
            this.mapeador.aEntidad(modelo)));
    }

    @Override
    public Parqueadero buscarPorId(Long id) {
        return repositorio.findById(id).map(mapeador::aDominio).orElse(null);
    }

    @Override
    public List<Parqueadero> listarTodo() {
        return repositorio.findAll().stream().map(mapeador::aDominio).toList();
    }

    @Override
    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public void actualizar(Parqueadero modelo) {
        repositorio.save(
        mapeador.aEntidad(modelo));
    }

    @Override
    public Parqueadero buscarPorIdUsuario(Long idUsuario) {
        return this.repositorio.findByUsuarioId(idUsuario)
                .map(mapeador::aDominio).orElse(null);
    }
}
