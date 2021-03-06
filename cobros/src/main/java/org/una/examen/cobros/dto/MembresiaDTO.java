/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.cobros.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor 
@ToString
public class MembresiaDTO {
    private Long id;
    private int periodicidad;  
    private float monto;
    private String descripcion;
    private boolean estado;
    private ClienteDTO cliente;
    private TipoServicioDTO tipoServicio;
    private Date fechaVenceMembresia;
   
}
