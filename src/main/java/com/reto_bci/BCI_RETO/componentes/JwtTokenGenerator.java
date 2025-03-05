package com.reto_bci.BCI_RETO.componentes;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Date;
import com.reto_bci.BCI_RETO.entidades.UsuarioE;

@Component
public class JwtTokenGenerator {
    @Value("${app.jwtSecret}")
    private String secretKey;
    private long expirationTimeInMs = 3600000;

    public String generateAccessToken(UsuarioE usuarioE) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + expirationTimeInMs);

        String token = Jwts.builder()
                .setSubject(usuarioE.getId().toString())
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        return token;
    }
}
