/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.cobros.services;

import java.util.List;
import java.util.Optional;
import org.una.examen.cobros.dto.CobroPendienteDTO;

/**
 *
 * @author Luis
 */
public interface ICobroPendienteService {
    
    public Optional<List<CobroPendienteDTO>> findAll();
    
//    public Optional<List<CobroPendienteDTO>> findByEstado(int estado);

    public Optional<CobroPendienteDTO> findById(Long id);
    
    public CobroPendienteDTO create(CobroPendienteDTO cobroPendiente);

    public Optional<CobroPendienteDTO> update(CobroPendienteDTO cobroPendiente, Long id);
    
//    public Optional<List<CobroPendienteDTO>> findByMembrecia(Long cobroPendiente);
}
