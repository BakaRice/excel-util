package com.ricemarch.excelutil.common.excel.annotation;

import com.ricemarch.excelutil.common.excel.converter.DefaultConvertible;
import com.ricemarch.excelutil.common.excel.converter.ReadConvertible;
import com.ricemarch.excelutil.common.excel.converter.WriteConvertible;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 功能说明: 用来在对象的属性上加入的annotation，通过该annotation说明某个属性所对应的标题
 *
 * @author tanwentao
 * @version 0.1
 * @since 2021/03/30
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelField {

    /**
     * 属性的表格名称
     *
     * @return 表头名
     */
    String title();

    /**
     * 写数据转换器
     *
     * @return 写入Excel数据转换器
     * @see WriteConvertible
     */
    Class<? extends WriteConvertible> writeConverter() default DefaultConvertible.class;

    /**
     * 读数据转换器
     *
     * @return 读取Excel数据转换器
     * @see ReadConvertible
     */
    Class<? extends ReadConvertible> readConverter() default DefaultConvertible.class;

    /**
     * 在excel的顺序
     *
     * @return 列表顺序
     */
    int order() default 9999;

}
