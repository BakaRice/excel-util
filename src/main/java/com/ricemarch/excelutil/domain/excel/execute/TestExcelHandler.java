package com.ricemarch.excelutil.domain.excel.execute;

import com.ricemarch.excelutil.domain.excel.handler.AbstractExcelHandler;
import com.ricemarch.excelutil.model.excel.TestExcel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @author tanwentao
 * @since 2021/3/30
 */
@Component
@Slf4j
public class TestExcelHandler extends AbstractExcelHandler {
    @Override
    public String getSheetName() {
        return "TestExcel表格";
    }

    @Override
    public List<TestExcel> uploadExcel(int sheetIndex, InputStream inputStream, List<String> resultErrorUrls) {
        int offsetLine = 0;
        int limitLine = 1000;
        List<TestExcel> testExcelList = this.handler(inputStream, TestExcel.class, offsetLine, limitLine, sheetIndex);
        log.info(getSheetName() + "导入:{}", testExcelList.toString());
        return testExcelList;
    }


    @Override
    public void downloadExcel(List<?> data, OutputStream os) {
        log.info(getSheetName() + "导出:{}", data.toString());
        this.handlerDownload(data, TestExcel.class, Boolean.TRUE, getSheetName(), Boolean.FALSE, os);
    }

}
