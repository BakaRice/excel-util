package com.ricemarch.excelutil.common.excel.converter;

/**
 * @author tanwentao
 * @since 2021/3/30
 */

public interface WriteConvertible {
    /**
     * 写入Excel列内容转换
     *
     * @param object 待转换数据
     * @return  转换完成的结果
     */
    Object execWrite(Object object);
}
