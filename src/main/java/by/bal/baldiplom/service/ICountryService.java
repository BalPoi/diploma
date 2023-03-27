package by.bal.baldiplom.service;

import by.bal.baldiplom.dto.ReadCountryDto;
import by.bal.baldiplom.dto.WriteCountryDto;

import java.util.List;

public interface ICountryService {
    List<ReadCountryDto> getAllCountries();

    ReadCountryDto getCountryById(int id);

    void editCountryById(int id, WriteCountryDto countryDto);

    void deleteCountryById(int id);

    int addCountry(WriteCountryDto countryDto);
}
