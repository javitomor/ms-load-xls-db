package org.loadxls.services;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.IOException;

public interface LoadService {
    public void cargarArchivo(@NotNull MultipartFile file) throws IOException;
}
