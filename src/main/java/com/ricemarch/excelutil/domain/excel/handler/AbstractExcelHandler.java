package com.ricemarch.excelutil.domain.excel.handler;

import com.ricemarch.excelutil.common.excel.ExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
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
public abstract class AbstractExcelHandler implements ExcelCommonHandler {

    public List handler(InputStream is, Class clazz, int offsetLine, int limitLine, int sheetIndex) {
        try {
            List result = ExcelUtils.getInstance().readExcel2Objects(is, clazz, offsetLine, limitLine, sheetIndex);
            if (CollectionUtils.isEmpty(result)) {
                throw new RuntimeException("import Excel is null");
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("AbstractExcelHandlerError:" + clazz.getName() + ":" + e.getMessage());
        }
    }

    public void handlerDownload(List<?> data, Class clazz, boolean isWriteHeader, String sheetName, boolean isXSSF, OutputStream os) {
        try {
            ExcelUtils.getInstance().exportObjects2Excel(data, clazz, isWriteHeader, sheetName, isXSSF, os);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("AbstractExcelHandlerError:" + clazz.getName() + ":" + e.getMessage());
        }
    }
}
