package by.bal.baldiplom.controller;

import by.bal.baldiplom.dto.ReadParkingStationDto;
import by.bal.baldiplom.dto.WriteParkingStationDto;
import by.bal.baldiplom.service.IParkingStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stations")
public class ParkingStationController {
    private final IParkingStationService stationService;

    @Autowired
    public ParkingStationController(IParkingStationService scooterService) {
        this.stationService = scooterService;
    }

    @PostMapping
    public int addStation(@RequestBody WriteParkingStationDto stationDto) {
        return stationService.addStation(stationDto);
    }

    @GetMapping
    public List<ReadParkingStationDto> getAllStations() {
        return stationService.getAllStations();
    }

    @GetMapping("/{id}")
    public ReadParkingStationDto getStationById(@PathVariable int id) {
        return stationService.getStationById(id);
    }

    @PutMapping("/{id}")
    public void editStationById(@PathVariable int id,
                                @RequestBody WriteParkingStationDto stationDto) {
        stationService.editStation(id, stationDto);
    }

    @DeleteMapping("/{id}")
    public void deleteStationById(@PathVariable int id) {
        stationService.deleteStationById(id);
    }
}
