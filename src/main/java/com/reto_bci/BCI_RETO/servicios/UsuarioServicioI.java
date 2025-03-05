package com.reto_bci.BCI_RETO.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.reto_bci.BCI_RETO.entidades.UsuarioE;
import com.reto_bci.BCI_RETO.modelos.Usuario;
import com.reto_bci.BCI_RETO.componentes.UsuarioComponente;
import com.reto_bci.BCI_RETO.repositorio.UsuarioRepositorio;
// import com.reto_bci.BCI_RETO.servicios.UsuarioServicio;
import com.reto_bci.BCI_RETO.util.ExcepcionesUsuario;

import static com.reto_bci.BCI_RETO.util.ConstanteUtil.*;

@Service
public class UsuarioServicioI implements UsuarioServicio{

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private UsuarioComponente usuarioComponente;

    public UsuarioE RegistroUsuario(Usuario usuario){
        validarUsuario(usuario);
        UsuarioE newUsuarioE = usuarioComponente.crearUsuarioUC(usuario);
        return usuarioRepositorio.save(newUsuarioE);
    }

    private void validarUsuario(Usuario usuario){
        if (!ValidarEmail(usuario.getEmail())) {
            throw new ExcepcionesUsuario(FORMATO_EMAIL_INVALIDO);
        }
        if (!ValidarPassword(usuario.getPassword())) {
            throw new ExcepcionesUsuario(FORMATO_PASS_INVALIDO);
        }
        UsuarioE UsuarioExiste = usuarioRepositorio.findByEmail(usuario.getEmail());
        if (UsuarioExiste != null) {
            throw new ExcepcionesUsuario(REGISTRO_EMAIL);
        }
    }

    private boolean ValidarEmail(String email) {
        Pattern emailPattern = Pattern.compile(EMAIL_REGISTRO);
        Matcher emailMatcher = emailPattern.matcher(email);
        return emailMatcher.matches();
    }

    private boolean ValidarPassword(String password) {
        Pattern passwordPattern = Pattern.compile(PASSWORD_REGISTRO);
        Matcher passwordMatcher = passwordPattern.matcher(password);
        return passwordMatcher.matches();
    }
    
}
