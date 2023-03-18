package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class PersonaDTO implements Serializable {

    private String nombre;

    private String apellido;

    private String correo;

    private Integer edad;

    private Integer numeroDocumentoIdentificacion;
}
