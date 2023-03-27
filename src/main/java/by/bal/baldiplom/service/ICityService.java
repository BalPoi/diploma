package by.bal.baldiplom.service;

import by.bal.baldiplom.dto.ReadCityDto;
import by.bal.baldiplom.dto.WriteCityDto;

import java.util.List;

public interface ICityService {
    List<ReadCityDto> getAllCities();

    ReadCityDto getCityById(int id);

    void editCityById(int id, WriteCityDto cityDto);

    void deleteCityById(int id);

    int addCity(WriteCityDto cityDto);
}
