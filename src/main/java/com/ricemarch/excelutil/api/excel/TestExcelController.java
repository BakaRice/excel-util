package com.ricemarch.excelutil.api.excel;

import com.ricemarch.excelutil.domain.excel.execute.TestExcelHandler;
import com.ricemarch.excelutil.model.excel.TestExcel;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * TestExcel 表格 下载
 *
 * @author tanwentao
 * @since 2021/3/30
 */
@RestController
@RequestMapping("/test/excel")
@Slf4j
public class TestExcelController {

    @Autowired
    TestExcelHandler testExcelHandler;

    @GetMapping("/download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
        OutputStream os = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Workbook workbook = new HSSFWorkbook();
        String agent = request.getHeader("User-Agent");
        String fileName = "TestExcelReport-" + sdf.format(new Date()) + ".xlsx";

        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        os = response.getOutputStream();
        //----new list of download object----//
        List<TestExcel> list = new ArrayList<>();
        TestExcel testExcel = new TestExcel();
        testExcel.setCustomerId("11");
        testExcel.setAmount("123");
        testExcel.setPresentAmount("321");
        testExcel.setErrorMsg("hhhh");
        list.add(testExcel);
        testExcelHandler.downloadExcel(list, os);
        try {
            response.flushBuffer();
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            log.error("download error", e);
        }
    }
}
