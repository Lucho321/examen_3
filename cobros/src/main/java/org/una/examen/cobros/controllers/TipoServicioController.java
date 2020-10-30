/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.cobros.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.una.examen.cobros.services.ITipoServicioService;
import org.una.examen.cobros.dto.TipoServicioDTO;
/**
 *
 * @author Luis
 */

@RestController
@RequestMapping("/tipoServicio") 
public class TipoServicioController {
    
    @Autowired
    private ITipoServicioService tipoServicioService;
    
    final String MENSAJE_VERIFICAR_INFORMACION = "Debe verificar el formato y la información de su solicitud con el formato esperado";

    @GetMapping("/") 
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity<>(tipoServicioService.findAll(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getClass(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/{id}") 
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {
            return new ResponseEntity<>(tipoServicioService.findById(id), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/crear") 
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody TipoServicioDTO tipoServicio,  BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            try {
                return new ResponseEntity(tipoServicioService.create(tipoServicio), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
        return new ResponseEntity(MENSAJE_VERIFICAR_INFORMACION, HttpStatus.BAD_REQUEST);
        }
    }
    

    @PutMapping("/modificar/{id}") 
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody TipoServicioDTO tipoServicioModificado, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            try {
                Optional<TipoServicioDTO> empleadoUpdated = tipoServicioService.update(tipoServicioModificado, id);
                if (empleadoUpdated.isPresent()) {
                    return new ResponseEntity(empleadoUpdated, HttpStatus.OK);
                } else {
                    return new ResponseEntity(HttpStatus.NOT_FOUND);
                }
            } catch (Exception e) {
                return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity(MENSAJE_VERIFICAR_INFORMACION, HttpStatus.BAD_REQUEST);
        }
    }
}
