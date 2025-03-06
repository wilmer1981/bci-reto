package com.reto_bci.BCI_RETO.componentes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.reto_bci.BCI_RETO.entidades.UsuarioE;
import com.reto_bci.BCI_RETO.entidades.TelefonoE;
import com.reto_bci.BCI_RETO.modelos.Usuario;
import com.reto_bci.BCI_RETO.modelos.Telefono;

@Component
public class UsuarioComponente {
    @Autowired
    private JwtTokenGenerator jwtTokenGenerator;

    public UsuarioE crearUsuarioUC(Usuario usuario) {

        UsuarioE newUsuarioE = new UsuarioE();
        newUsuarioE.setId(UUID.randomUUID());
        newUsuarioE.setName(usuario.getName());
        newUsuarioE.setEmail(usuario.getEmail());
        newUsuarioE.setPassword(usuario.getPassword());

        List<TelefonoE> telefonos = usuario.getPhones().stream()
                .map(this::crearTelefonoUC)
                .collect(Collectors.toList());
        newUsuarioE.setPhones(telefonos);

        Date date = new Date();
        newUsuarioE.setCreated(date);
        newUsuarioE.setModified(date);
        newUsuarioE.setLast_login(date);

        String accesoToken = jwtTokenGenerator.generateAccessToken(newUsuarioE);
        newUsuarioE.setToken(accesoToken);
        newUsuarioE.setIsactive(true);

        return newUsuarioE;
    }

    private TelefonoE crearTelefonoUC(Telefono telefono) {
        TelefonoE telefonoE = new TelefonoE();
        telefonoE.setNumber(telefono.getNumber());
        telefonoE.setCitycode(telefono.getCitycode() != null ? telefono.getCitycode() : "");
        telefonoE.setContrycode(telefono.getContrycode() != null ? telefono.getContrycode() : "");
        return telefonoE;
    }

}
