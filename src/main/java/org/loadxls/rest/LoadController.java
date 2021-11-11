package org.loadxls.rest;

import org.loadxls.exceptions.LoadFileException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.loadxls.services.LoadService;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.io.IOException;

@RestController
@RequestMapping("/load")
@Slf4j
public class LoadController {

    @Autowired
    LoadService loadService;

    @Transactional
    @PostMapping("/file")
    @ApiOperation(value = "Permite cargar datos desde un archivo XLS",response = String.class)
    public ResponseEntity<String> loadPuestos(
           @ApiParam(value = "Archivo con los Puestos") @RequestPart("file") @NotNull MultipartFile file){

        try {

            loadService.cargarArchivo(file);

        return ResponseEntity.ok("Todo Ok");

        } catch (IOException ex) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

            throw new LoadFileException("Error al cargar el archivo");
        }

    }

}