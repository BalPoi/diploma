package by.bal.baldiplom.enity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
