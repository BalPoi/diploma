package by.bal.baldiplom.dto;

import lombok.Data;

@Data
public class ExceptionDto {
    int status;
    String message;
    long timestamp;
}
