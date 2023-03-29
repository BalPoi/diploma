package by.bal.baldiplom.dto;

import lombok.Data;

@Data
public class WriteRentalSessionDto {
    long userId;
    int scooterId;
    int beginStationId;
}
