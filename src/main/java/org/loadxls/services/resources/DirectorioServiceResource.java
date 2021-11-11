package org.loadxls.services.resources;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface DirectorioServiceResource {

    public File obtenerDirectorioTemporal();

    public void copiarArchivoARutaLocal(MultipartFile file, String rutaArchivoLocal)throws IOException;
}
