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
import org.una.examen.cobros.dto.MembresiaDTO;
import org.una.examen.cobros.repositories.IMembresiaRepository;
import org.una.examen.cobros.util.MapperUtils;
import org.una.examen.cobros.util.ServiceConvertionHelper;
import org.una.examen.cobros.entities.Membresia;
/**
 *
 * @author Luis
 */
@Service
public class MembresiaServiceImplementation implements IMembresiaService{

    @Autowired
    private IMembresiaRepository membresiaRepository;
        
    @Override
    public Optional<List<MembresiaDTO>> findAll() {
        return ServiceConvertionHelper.findList(membresiaRepository.findAll(), MembresiaDTO.class);
    }


    @Override
    public Optional<MembresiaDTO> findById(Long id) {
        return ServiceConvertionHelper.oneToOptionalDto(membresiaRepository.findById(id), MembresiaDTO.class);
    }


    @Override
    public MembresiaDTO create(MembresiaDTO membresia) {
        Membresia vuel = MapperUtils.EntityFromDto(membresia, Membresia.class);
        vuel = membresiaRepository.save(vuel);
        return MapperUtils.DtoFromEntity(vuel, MembresiaDTO.class);
    }

    @Override
    public Optional<MembresiaDTO> update(MembresiaDTO membresia, Long id) {
        if (membresiaRepository.findById(id).isPresent()) {
            Membresia membre = MapperUtils.EntityFromDto(membresia, Membresia.class);
            membre = membresiaRepository.save(membre);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(membre, MembresiaDTO.class));
        } else {
            return null;
        } 
    }

    
}
