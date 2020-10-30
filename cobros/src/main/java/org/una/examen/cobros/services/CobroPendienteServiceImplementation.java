/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.cobros.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.examen.cobros.dto.ClienteDTO;
import org.una.examen.cobros.dto.CobroPendienteDTO;
import org.una.examen.cobros.repositories.ICobroPendienteRepository;
import org.una.examen.cobros.util.MapperUtils;
import org.una.examen.cobros.util.ServiceConvertionHelper;
import org.una.examen.cobros.entities.CobroPendiente;

/**
 *
 * @author Luis
 */
@Service
public class CobroPendienteServiceImplementation implements ICobroPendienteService{

    @Autowired
    private ICobroPendienteRepository cobroPendienteRepository;
    
    @Override
    public Optional<List<CobroPendienteDTO>> findAll() {
        return ServiceConvertionHelper.findList(cobroPendienteRepository.findAll(), CobroPendienteDTO.class);
    }

    @Override
    public Optional<CobroPendienteDTO> findById(Long id) {
        return ServiceConvertionHelper.oneToOptionalDto(cobroPendienteRepository.findById(id), CobroPendienteDTO.class);
    }

    @Override
    public CobroPendienteDTO create(CobroPendienteDTO cobroPendiente) {
        CobroPendiente cobroPend = MapperUtils.EntityFromDto(cobroPendiente, CobroPendiente.class);
        cobroPend = cobroPendienteRepository.save(cobroPend);
        return MapperUtils.DtoFromEntity(cobroPend, CobroPendienteDTO.class);
    }

    @Override
    public Optional<CobroPendienteDTO> update(CobroPendienteDTO cobroPendiente, Long id) {
        if (cobroPendienteRepository.findById(id).isPresent()) {
            CobroPendiente cobroPend = MapperUtils.EntityFromDto(cobroPendiente, CobroPendiente.class);
            cobroPend = cobroPendienteRepository.save(cobroPend);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(cobroPend, CobroPendienteDTO.class));
        } else {
            return null;
        } 
    }


    
}
