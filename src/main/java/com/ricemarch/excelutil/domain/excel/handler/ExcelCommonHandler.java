package com.ricemarch.excelutil.domain.excel.handler;

import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @author tanwentao
 * @since 2021/3/30
 */
@Component
public interface ExcelCommonHandler {
    String getSheetName();

    List uploadExcel(int sheetIndex, InputStream inputStream, List<String> resultErrorUrls);

    void uploadExcelError(List<?> data, String sheetName, OutputStream os);

}
