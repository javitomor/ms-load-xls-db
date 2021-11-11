package org.loadxls.services.resources.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.loadxls.services.resources.DirectorioServiceResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class DirectorioServiceResourceImpl implements DirectorioServiceResource {

    @Value("${dir.temp.xls}")
    private String rutaTemporalXls;

    public File obtenerDirectorioTemporal(){

        return new File(new ClassPathResource(rutaTemporalXls).getPath());

    }

    public void copiarArchivoARutaLocal(MultipartFile file, String rutaArchivoLocal)
            throws IOException {
        byte[] bytes = file.getBytes();
        Path path = Paths.get(rutaArchivoLocal);
        Files.write(path, bytes);

    }

}
