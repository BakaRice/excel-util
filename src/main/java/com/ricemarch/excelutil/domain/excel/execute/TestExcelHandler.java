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
        return "测试表格导入";
    }

    @Override
    public List<TestExcel> uploadExcel(int sheetIndex, InputStream inputStream, List<String> resultErrorUrls) {
        int offsetLine = 0;
        int limitLine = 1000;
        List<TestExcel> testExcelList = this.handler(inputStream, TestExcel.class, offsetLine, limitLine, sheetIndex);

        log.info("TestExcel表格导入:{}", testExcelList.toString());
        return testExcelList;
    }

    @Override
    public void uploadExcelError(List<?> data, String sheetName, OutputStream os) {
        this.handlerError(data, TestExcel.class, Boolean.TRUE, sheetName, Boolean.FALSE, os);
    }

}
