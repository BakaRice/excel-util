package com.ricemarch.excelutil.common.excel.converter;

/**
 * 默认转换器，实现了{@link IOConvertible}接口
 * <p>
 * {@link IOConvertible} 继承了 {@link WriteConvertible} 与 {@link ReadConvertible}接口
 *
 * @author tanwentao
 * @since 2021/3/30
 */

public class DefaultConvertible implements IOConvertible {


    @Override
    public Object execRead(String object) {
        return null;
    }

    @Override
    public Object execWrite(Object object) {
        return null;
    }
}
