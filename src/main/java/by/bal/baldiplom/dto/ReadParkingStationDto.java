package by.bal.baldiplom.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ReadParkingStationDto {
    int id;
    String address;
    int slotsNumber;
    int freeSlotsNumber;
    int cityId;
    BigDecimal latitude;
    BigDecimal longitude;
}
