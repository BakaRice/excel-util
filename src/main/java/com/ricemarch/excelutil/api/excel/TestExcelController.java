package com.ricemarch.excelutil.api.excel;

import com.ricemarch.excelutil.domain.excel.ExcelFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanwentao
 * @since 2021/3/30
 */
@RestController
@RequestMapping("/test/excel")
@Slf4j
public class TestExcelController {

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file == null) {
            throw new RuntimeException("please upload file");
        }
        List<String> resultErrorUrls = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
            XSSFSheet sheet = null;
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                sheet = workbook.getSheetAt(i);
                if (null == sheet) {
                    continue;
                }
                String sheetName = sheet.getSheetName();
                if (null == ExcelFactory.getExcelComHandler(sheetName)) {
                    throw new RuntimeException(sheetName + "sheet名称不存在对应模板代码");
                }
            }
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                sheet = workbook.getSheetAt(i);
                String sheetName = sheet.getSheetName();
                ExcelFactory.getExcelComHandler(sheetName).uploadExcel(i, file.getInputStream(), resultErrorUrls);
            }

            StringBuffer rMsg = new StringBuffer();
            for (String resultErrorUrl : resultErrorUrls) {
                rMsg.append(resultErrorUrl).append(",");
            }
            return rMsg.append("END!").toString();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            log.error("excel导入失败:", e);
            throw new RuntimeException("excel导入失败:" + e.getMessage());
        }
    }
}
