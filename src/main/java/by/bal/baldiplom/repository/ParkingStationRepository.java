package by.bal.baldiplom.repository;

import by.bal.baldiplom.enity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingStationRepository extends JpaRepository<Station, Integer> {
}
