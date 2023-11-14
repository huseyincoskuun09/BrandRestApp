package com.coskun.demoone.exception;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExceptionResponse {
    private LocalDateTime timestamp;
    private String massege;
    private String code ;



}
