/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.cobros.services;

import java.util.List;
import java.util.Optional;
import org.una.examen.cobros.dto.ClienteDTO;

/**
 *
 * @author Luis
 */
public interface IClienteService {
    public Optional<List<ClienteDTO>> findAll();
    
    public Optional<List<ClienteDTO>> findByNombreContainingIgnoreCase(String nombre);

    public Optional<ClienteDTO> findById(Long id);
    
    public ClienteDTO create(ClienteDTO cliente);

    public Optional<ClienteDTO> update(ClienteDTO cliente, Long id);
    
}
