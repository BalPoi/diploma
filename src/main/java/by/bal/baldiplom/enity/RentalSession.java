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
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "rental_sessions")
public class RentalSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "scooter_id")
    Scooter scooter;

    LocalDateTime beginTime;
    LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "begin_station_id")
    Station beginStation;

    @ManyToOne
    @JoinColumn(name = "end_station_id")
    Station endStation;
}
