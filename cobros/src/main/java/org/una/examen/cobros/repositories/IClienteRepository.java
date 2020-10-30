/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.cobros.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.una.examen.cobros.entities.Cliente;
/**
 *
 * @author Luis
 */
public interface IClienteRepository extends JpaRepository<Cliente, Long>{
    public List<Cliente> findByNombreContainingIgnoreCase(String nombre);
    

}
