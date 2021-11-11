package org.loadxls.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.loadxls.services.LoadService;
import org.loadxls.services.PersistirService;
import org.loadxls.services.resources.DirectorioServiceResource;
import org.loadxls.services.resources.impl.DirectorioServiceResourceImpl;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;

@Service
public class LoadServiceImpl implements LoadService {

    DirectorioServiceResource directorioService;
    PersistirService persistirService;

    public LoadServiceImpl(
            DirectorioServiceResource directorioService,
            PersistirService persistirService
    ){
        this.directorioService=directorioService;
        this.persistirService=persistirService;
    }
    public LoadServiceImpl(){
        this.directorioService=new DirectorioServiceResourceImpl();
        this.persistirService = new PersistirServiceImpl();
    }

    public void cargarArchivo(@NotNull MultipartFile file) throws IOException {
        File directorioTemporalLocal =
                directorioService.obtenerDirectorioTemporal();

        String rutaArchivoLocal =
                directorioTemporalLocal.getAbsolutePath() + "/" + file.getOriginalFilename().toLowerCase();

        File archivoLocal = new File(rutaArchivoLocal);

        directorioService.copiarArchivoARutaLocal(file, rutaArchivoLocal);

        persistirService.persistirDatosDeXls(rutaArchivoLocal);

        archivoLocal.delete();
        directorioTemporalLocal.delete();

    }
}
