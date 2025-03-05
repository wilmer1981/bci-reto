package com.reto_bci.BCI_RETO.repositorio;

import com.reto_bci.BCI_RETO.entidades.UsuarioE;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<UsuarioE,UUID> {
    UsuarioE findByEmail(String email);
}
