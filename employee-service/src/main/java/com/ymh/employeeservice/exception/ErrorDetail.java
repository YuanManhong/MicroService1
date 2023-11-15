package com.ymh.employeeservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
@Getter
@AllArgsConstructor
public class ErrorDetail {
    private Date timestamp;
    private String message;
    private String detail;
}
