package com.ymh.departmentService.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
@AllArgsConstructor
@Getter
public class ErrorDetail {
    private Date timestamp;
    private String message;
    private String details;
}
