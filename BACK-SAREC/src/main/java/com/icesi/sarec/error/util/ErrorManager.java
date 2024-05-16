package com.icesi.sarec.error.util;

import com.icesi.sarec.error.exception.ErrorCode;
import com.icesi.sarec.error.exception.ErrorDetail;

public class ErrorManager {
    public static ErrorDetail createDetail(String message, ErrorCode errorCode){
        return ErrorDetail.builder().errorCode(errorCode).errorMessage(message).build();
    }

    public static ErrorDetail[] sendDetails(ErrorDetail ... details){
        return details;
    }
}
