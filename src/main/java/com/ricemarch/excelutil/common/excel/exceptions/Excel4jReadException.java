package com.ricemarch.excelutil.common.excel.exceptions;

/**
 * @author tanwentao
 * @since 2021/3/30
 */

public class Excel4jReadException extends RuntimeException {
    private static final long serialVersionUID = 8735084330744657672L;

    public Excel4jReadException() {
    }

    public Excel4jReadException(String message) {
        super(message);
    }

    public Excel4jReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
