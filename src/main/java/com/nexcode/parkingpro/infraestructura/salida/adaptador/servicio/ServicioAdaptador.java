package com.nexcode.parkingpro.infraestructura.salida.adaptador.servicio;

import com.nexcode.parkingpro.dominio.modelo.Servicio;
import com.nexcode.parkingpro.dominio.puertos.servicio.ServicioPersistencia;
import com.nexcode.parkingpro.infraestructura.salida.persistencia.servicio.ServicioRepositorio;
import com.nexcode.parkingpro.infraestructura.salida.mapeador.servicio.ServicioMapeador;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ServicioAdaptador implements ServicioPersistencia {

    private final ServicioRepositorio repositorio;
    private final ServicioMapeador mapeador;

    @Override
    public Servicio guardar(Servicio modelo) {
        return this.mapeador.aDominio(this.repositorio.save(
            this.mapeador.aEntidad(modelo)));
    }

    @Override
    public Servicio buscarPorId(Long id) {
        return repositorio.findById(id).map(mapeador::aDominio).orElse(null);
    }

    @Override
    public List<Servicio> listarTodo() {
        return repositorio.findAll().stream().map(mapeador::aDominio).toList();
    }

    @Override
    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public void actualizar(Servicio modelo) {
        repositorio.save(
        mapeador.aEntidad(modelo));
    }
}
