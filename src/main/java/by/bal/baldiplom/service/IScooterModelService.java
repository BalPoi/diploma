package by.bal.baldiplom.service;

import by.bal.baldiplom.dto.ReadScooterModelDto;
import by.bal.baldiplom.dto.WriteScooterModelDto;

import java.util.List;

public interface IScooterModelService {
    int addScooterModel(WriteScooterModelDto modelDto);

    List<ReadScooterModelDto> getAllScooterModels();

    ReadScooterModelDto getScooterModelById(int id);

    void editScooterModelById(int id, WriteScooterModelDto modelDto);

    void deleteScooterModelById(int id);
}
