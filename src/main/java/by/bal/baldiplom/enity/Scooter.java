package by.bal.baldiplom.enity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "scooters")
public class Scooter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String serialNumber;
    int chargePercentage;

    @ManyToOne
    @JoinColumn(name = "model_id")
    ScooterModel model;

    @Enumerated(EnumType.STRING)
    Status status;

    private enum Status {
        FREE,
        BOOKED,
        ENGAGED,
        INACTIVE
    }
}
