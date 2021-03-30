package com.ricemarch.excelutil.common.excel.exceptions;

/**
 * @author tanwentao
 * @since 2021/3/30
 */

public class IllegalGroupIndexException extends RuntimeException {

    private static final long serialVersionUID = 7725478743860387475L;

    public IllegalGroupIndexException(String message) {
        super(message);
    }
}