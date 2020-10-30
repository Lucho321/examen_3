/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.cobros.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 *
 * @author Luis
 */
@Entity
@Table(name = "exa_lvn_membresias")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Membresia implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private int periodicidad;
    
    @Column
    private float monto;
    
    @Column(length = 50)
    private String descripcion;
    
    @Column
    private boolean estado;
    
    @Column(name = "fecha_vence_membresia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVenceMembresia;
    
    @ManyToOne 
    @JoinColumn(name="clientes_id")
    private Cliente cliente;
    
    @ManyToOne 
    @JoinColumn(name="tipos_servicios_id", nullable = false)
    private TipoServicio tipoServicio;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "membresia") 
    private List<CobroPendiente> cobroPendiente = new ArrayList<>();
    
 
    
}
