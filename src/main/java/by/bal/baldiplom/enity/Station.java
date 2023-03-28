package by.bal.baldiplom.enity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
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
