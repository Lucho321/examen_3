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
import org.una.examen.cobros.repositories.IClienteRepository;
import org.una.examen.cobros.util.MapperUtils;
import org.una.examen.cobros.util.ServiceConvertionHelper;
import org.una.examen.cobros.entities.Cliente;

/**
 *
 * @author Luis
 */
@Service
public class ClienteServiceImplementation implements IClienteService{

    @Autowired
    private IClienteRepository clienteRepository;
    
    @Override
    public Optional<List<ClienteDTO>> findAll() {
        return ServiceConvertionHelper.findList(clienteRepository.findAll(), ClienteDTO.class);
    }

    @Override
    public Optional<List<ClienteDTO>> findByNombreContainingIgnoreCase(String nombre) {
        return ServiceConvertionHelper.findList(clienteRepository.findByNombreContainingIgnoreCase(nombre), ClienteDTO.class);
    }

    @Override
    public Optional<ClienteDTO> findById(Long id) {
        return ServiceConvertionHelper.oneToOptionalDto(clienteRepository.findById(id), ClienteDTO.class);
    }

    @Override
    public ClienteDTO create(ClienteDTO cliente) {
        Cliente clie = MapperUtils.EntityFromDto(cliente, Cliente.class);
        clie = clienteRepository.save(clie);
        return MapperUtils.DtoFromEntity(clie, ClienteDTO.class);
    }

    @Override
    public Optional<ClienteDTO> update(ClienteDTO cliente, Long id) {
        if (clienteRepository.findById(id).isPresent()) {
            Cliente clie = MapperUtils.EntityFromDto(cliente, Cliente.class);
            clie = clienteRepository.save(clie);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(clie, ClienteDTO.class));
        } else {
            return null;
        } 
    }



    
}
