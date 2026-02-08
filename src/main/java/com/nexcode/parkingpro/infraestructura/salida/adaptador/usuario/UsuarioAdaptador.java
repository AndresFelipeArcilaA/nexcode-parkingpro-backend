package com.nexcode.parkingpro.infraestructura.salida.adaptador.usuario;

import com.nexcode.parkingpro.dominio.modelo.Usuario;
import com.nexcode.parkingpro.dominio.puertos.usuario.UsuarioPersistencia;
import com.nexcode.parkingpro.infraestructura.salida.persistencia.usuario.UsuarioRepositorio;
import com.nexcode.parkingpro.infraestructura.salida.mapeador.usuario.UsuarioMapeador;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UsuarioAdaptador implements UsuarioPersistencia {

    private final UsuarioRepositorio repositorio;
    private final UsuarioMapeador mapeador;

    @Override
    public Usuario guardar(Usuario modelo) {
        return this.mapeador.aDominio(this.repositorio.save(
            this.mapeador.aEntidad(modelo)));
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return repositorio.findById(id).map(mapeador::aDominio).orElse(null);
    }

    @Override
    public List<Usuario> listarTodo() {
        return repositorio.findAll().stream().map(mapeador::aDominio).toList();
    }

    @Override
    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public void actualizar(Usuario modelo) {
        repositorio.save(
        mapeador.aEntidad(modelo));
    }

    @Override
    public Usuario buscarPorCorreoYContrasena(String correo, String contrasena) {
        return this.repositorio.findByCorreoAndContrasena(correo, contrasena)
        .map(mapeador::aDominio).orElse(null);
    }
}
