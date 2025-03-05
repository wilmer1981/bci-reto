package com.reto_bci.BCI_RETO.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Telefono {
    private String number, citycode, contrycode;
}
