package org.loadxls.services;

import org.apache.poi.ss.usermodel.Row;

import java.util.Map;

public interface CleanDataService {
    Map<String, String> obtenerDatosLimpiosDeFila(Row row);

    boolean isCellNull(Row row, int position);

    boolean isCellEmpty(Row row, int position);
    Row setCellblank(Row row, int position);
}
