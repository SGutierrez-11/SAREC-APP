package com.icesi.sarec.error.exception;


import lombok.*;


@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ErrorDetail {
    private ErrorCode errorCode;
    private String errorMessage;
}
