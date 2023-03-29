package by.bal.baldiplom.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReadRentalSessionDto {
    long id;
    long userId;
    int scooterId;
    LocalDateTime beginTime;
    LocalDateTime endTime;
    int beginStationId;
    int endStationId;
}
