/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.cobros.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.una.examen.cobros.entities.Cliente;
import org.una.examen.cobros.entities.Membresia;
/**
 *
 * @author Luis
 */
public interface IMembresiaRepository extends JpaRepository<Membresia, Long>{
    //public List<Membresia> findByMembresiaTipo(Long tipoMembresia);
    //bien
//    @Query("SELECT v FROM Membresia v LEFT JOIN v.tipoServicio a WHERE a.id = :tipo_servicio_ID")
//    public List<Membresia> findByTipoServicio(@Param("tipo_servicio_ID")Long tipo_servicio);
//    
//    @Query("SELECT v FROM Membresia v LEFT JOIN v.cliente a WHERE a.id = :tipo_servicio_ID")
//    public List<Membresia> findByCliente(@Param("tipo_servicio_ID")Long tipo_servicio);
//    
}
