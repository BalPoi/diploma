package by.bal.baldiplom.dto;

import lombok.Data;

@Data
public class WriteParkingStationDto {
    String address;
    int slotsNumber;
    int freeSlotsNumber;
    int cityId;
}
