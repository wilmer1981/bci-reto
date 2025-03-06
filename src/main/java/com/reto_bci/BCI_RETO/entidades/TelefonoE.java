package com.reto_bci.BCI_RETO.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "telefono")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TelefonoE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "citycode")
    private String citycode;

    @Column(name = "contrycode")
    private String contrycode;
}