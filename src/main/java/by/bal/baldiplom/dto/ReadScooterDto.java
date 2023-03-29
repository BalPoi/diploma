package by.bal.baldiplom.dto;

import by.bal.baldiplom.enity.Status;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ReadScooterDto {
    int id;
    String serialNumber;
    Status status;
    Integer chargePercentage;
    int modelId;
    BigDecimal latitude;
    BigDecimal longitude;
}
