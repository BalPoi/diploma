package by.bal.baldiplom.service;

import by.bal.baldiplom.dto.ReadParkingStationDto;
import by.bal.baldiplom.dto.WriteParkingStationDto;

import java.util.List;

public interface IParkingStationService {

    int addStation(WriteParkingStationDto stationDto);

    List<ReadParkingStationDto> getAllStations();

    ReadParkingStationDto getStationById(int id);

    void editStation(int id, WriteParkingStationDto stationDto);

    void deleteStationById(int id);
}
