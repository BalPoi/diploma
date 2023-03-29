package by.bal.baldiplom.service;

import by.bal.baldiplom.dto.ReadScooterDto;
import by.bal.baldiplom.dto.WriteScooterDto;

import java.util.List;

public interface IScooterService {
    int addScooter(WriteScooterDto scooterDto);

    List<ReadScooterDto> getAllScooters();

    ReadScooterDto getScooterById(int id);

    void editScooterById(int id, WriteScooterDto scooterDto);

    void deleteScooterById(int id);
}
