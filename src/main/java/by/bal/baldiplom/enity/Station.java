package by.bal.baldiplom.enity;

import jakarta.persistence.Entity;
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
@Table(name = "parking_stations")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String address;
    int slotsNumber;
    int freeSlotsNumber;

    @ManyToOne
    @JoinColumn(name = "city_id")
    City city;
}
