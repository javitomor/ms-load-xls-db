package org.loadxls.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.loadxls.services.CleanDataService;
import org.loadxls.services.PersistirService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;


@Service
@Slf4j
public class PersistirServiceImpl implements PersistirService {


    @Value("$(archivo.personas.priorizacion.manual.pagina)")
    public int numeroPaginaDefault;

    private CleanDataService cleanDataService;

    public PersistirServiceImpl(CleanDataService cleanDataService){
        this.cleanDataService=cleanDataService;
    }

    public PersistirServiceImpl(){
        this.cleanDataService=new CleanDataServiceImpl();
    }

    @Override
    public void persistirDatosDeXls(String rutaArchivoLocal) throws IOException {

        FileInputStream fis = new FileInputStream(new File(rutaArchivoLocal));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheetAt(numeroPaginaDefault);

        sheet.removeRowBreak(1);
        Iterator<Row> rowIt = sheet.iterator();
        rowIt.next();

        while (rowIt.hasNext()) {
            persistirLineaXls(rowIt.next());
        }
        workbook.close();
        fis.close();

    }

    private void persistirLineaXls(Row row){

        Map<String, String> datosExcel = cleanDataService.obtenerDatosLimpiosDeFila(row);


        if (datosExcel.size() > 0) {
            //TODO aquí va la logica para crear el entity y persistirlo;
           // List<Puesto> puesto = createPuesto(datosExcel, llamadoConcurso);
           //  listaPuestos.addAll(puestoService.save(puesto));

        }
    }
}
