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
import org.una.examen.cobros.entities.CobroPendiente;
/**
 *
 * @author Luis
 */
public interface ICobroPendienteRepository extends JpaRepository<CobroPendiente, Long>{
//    public List<CobroPendiente> findByEstado(int estado);
//    
//    @Query("SELECT v FROM CobroPendiente v LEFT JOIN v.membresia a WHERE a.id = :membresiaID")
//    public List<CobroPendiente> findByMembrecia(@Param("membresiaID")Long membresia);
}
