package com.reto_bci.BCI_RETO.repositorio;

import com.reto_bci.BCI_RETO.entidades.UsuarioE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<UsuarioE,Long> {
    UsuarioE findByEmail(String email);
}
