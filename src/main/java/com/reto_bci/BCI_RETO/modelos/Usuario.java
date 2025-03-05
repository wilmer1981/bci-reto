package com.reto_bci.BCI_RETO.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {
    private String name, email, password;
    private List<Telefono> phones;
}
