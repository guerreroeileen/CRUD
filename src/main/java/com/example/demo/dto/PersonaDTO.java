package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PersonaDTO implements Serializable {

    private String nombre;

    private String apellido;

    private String correo;

    private Integer edad;

    private Integer numeroDocumentoIdentificacion;
}
