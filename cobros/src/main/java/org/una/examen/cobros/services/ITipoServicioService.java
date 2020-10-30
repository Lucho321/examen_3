/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.cobros.services;

import java.util.List;
import java.util.Optional;
import org.una.examen.cobros.dto.TipoServicioDTO;

/**
 *
 * @author Luis
 */
public interface ITipoServicioService {
    
    public Optional<List<TipoServicioDTO>> findAll();

    public Optional<TipoServicioDTO> findById(Long id);
    
    public TipoServicioDTO create(TipoServicioDTO tipoServicio);

    public Optional<TipoServicioDTO> update(TipoServicioDTO tipoServicio, Long id);


}
