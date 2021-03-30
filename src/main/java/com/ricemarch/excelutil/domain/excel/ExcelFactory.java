package com.ricemarch.excelutil.domain.excel;

import com.ricemarch.excelutil.domain.excel.handler.ExcelCommonHandler;
import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author tanwentao
 * @since 2021/3/30
 */
@Component
public class ExcelFactory implements ApplicationContextAware {

    private static Map<String, ExcelCommonHandler> excelBeanMap;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, ExcelCommonHandler> map = applicationContext.getBeansOfType(ExcelCommonHandler.class);
        excelBeanMap = new HashedMap();
        map.forEach((key, value) -> excelBeanMap.put(value.getSheetName(), value));
    }

    public static <T extends ExcelCommonHandler> T getExcelComHandler(String sheetName) {
        return (T) excelBeanMap.get(sheetName);
    }
}
