package com.example.CRUD_Clientes.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private Long idCliente;
    private String nombre;
    private String apellido;
    private String cedula;
    private String correo;
    private String direccion;
    private String telefono;
}