package org.loadxls.services.impl;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;
import org.loadxls.services.CleanDataService;

import java.util.HashMap;
import java.util.Map;

@Service
public class CleanDataServiceImpl implements CleanDataService {
    @Override
    public Map<String, String> obtenerDatosLimpiosDeFila(Row row) {

        //TODO aquí va la logica para asignarle una clave al valor de cada celda

        int position = 0;
        Map<String, String> datosExcel = new HashMap<String, String>();

        if (!isCellNull(row, position) && !isCellEmpty(row, position)) {

            datosExcel.put("ubicacionEstructural",
                    setCellblank(row, position).getCell(position).getStringCellValue());
            position++;
            datosExcel.put("denominacion",
                    setCellblank(row, position).getCell(position).getStringCellValue());
            position++;
            datosExcel.put("nivel", setCellblank(row, position).getCell(position).getStringCellValue());
            position++;
            datosExcel.put("agrupamiento",
                    setCellblank(row, position).getCell(position).getStringCellValue());
            position++;
            datosExcel.put("codigoNomenclador",
                    setCellblank(row, position).getCell(position).getStringCellValue());
            position++;
            datosExcel.put("reserva", setCellblank(row, position).getCell(position).getStringCellValue());
            position++;
            datosExcel.put("capacidadTerciaria",
                    setCellblank(row, position).getCell(position).getStringCellValue());
            position++;
            datosExcel.put("funcionEspecifica",
                    setCellblank(row, position).getCell(position).getStringCellValue());
            position++;
            datosExcel.put("funcionEjecutiva",
                    setCellblank(row, position).getCell(position).getStringCellValue());


        }

        return datosExcel;
    }

    @Override
    public boolean isCellNull(Row row, int position) {
        return (row.getCell(position) == null);
    }
    @Override
    public boolean isCellEmpty(Row row, int position) {
        return (row.getCell(position).getCellType() == CellType.BLANK);
    }
    @Override
    public Row setCellblank(Row row, int position) {
        if (row.getCell(position) == null) {
            row.createCell(position, CellType.BLANK);
        }
        return row;
    }
}
