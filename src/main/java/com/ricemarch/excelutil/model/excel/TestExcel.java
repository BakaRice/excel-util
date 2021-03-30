package com.ricemarch.excelutil.model.excel;

import com.ricemarch.excelutil.common.excel.annotation.ExcelField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tanwentao
 * @since 2021/3/30
 */
@Data
public class TestExcel implements Serializable {
    @ExcelField(title = "客户ID")
    private String customerId;

    @ExcelField(title = "本金")
    private String amount;

    @ExcelField(title = "赠送金")
    private String presentAmount;

    @ExcelField(title = "错误信息")
    private String errorMsg;
}
