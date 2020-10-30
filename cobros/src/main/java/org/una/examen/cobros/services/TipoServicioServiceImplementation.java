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
import org.una.examen.cobros.dto.TipoServicioDTO;
import org.una.examen.cobros.repositories.ITipoServicioRepository;
import org.una.examen.cobros.entities.TipoServicio;
import org.una.examen.cobros.util.MapperUtils;
import org.una.examen.cobros.util.ServiceConvertionHelper;
/**
 *
 * @author Luis
 */
@Service
public class TipoServicioServiceImplementation implements ITipoServicioService{
    
    @Autowired
    private ITipoServicioRepository tipoServicioRepository;
    
    @Override
    public Optional<List<TipoServicioDTO>> findAll() {
        return ServiceConvertionHelper.findList(tipoServicioRepository.findAll(), TipoServicioDTO.class);
    }

    @Override
    public Optional<TipoServicioDTO> findById(Long id) {
        return ServiceConvertionHelper.oneToOptionalDto(tipoServicioRepository.findById(id), TipoServicioDTO.class);
    }

    @Override
    public TipoServicioDTO create(TipoServicioDTO tipoServicio) {
        TipoServicio tipoS = MapperUtils.EntityFromDto(tipoServicio, TipoServicio.class);
        tipoS = tipoServicioRepository.save(tipoS);
        return MapperUtils.DtoFromEntity(tipoS, TipoServicioDTO.class);
    }

    @Override
    public Optional<TipoServicioDTO> update(TipoServicioDTO tipoServicio, Long id) {
        if (tipoServicioRepository.findById(id).isPresent()) {
            TipoServicio tipoS = MapperUtils.EntityFromDto(tipoServicio, TipoServicio.class);
            tipoS = tipoServicioRepository.save(tipoS);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(tipoS, TipoServicioDTO.class));
        } else {
            return null;
        } 
    }


    
}
