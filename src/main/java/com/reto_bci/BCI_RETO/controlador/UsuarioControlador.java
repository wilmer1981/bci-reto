package com.reto_bci.BCI_RETO.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.reto_bci.BCI_RETO.entidades.UsuarioE;
import com.reto_bci.BCI_RETO.modelos.Usuario;
import com.reto_bci.BCI_RETO.servicios.UsuarioServicio;
import com.reto_bci.BCI_RETO.util.ExcepcionesUsuario;
import com.reto_bci.BCI_RETO.util.ErrorRespuesta;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostMapping("/registro")
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuario usuario) {
        try {
            UsuarioE registrarUsuarioE = usuarioServicio.RegistroUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(registrarUsuarioE);
        } catch (ExcepcionesUsuario e) {
            ErrorRespuesta errorRespuesta = new ErrorRespuesta(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRespuesta);
        }
    }
}
