package by.bal.baldiplom.service.impl;

import by.bal.baldiplom.dto.ReadCityDto;
import by.bal.baldiplom.dto.WriteCityDto;
import by.bal.baldiplom.enity.City;
import by.bal.baldiplom.exception.ResourceNotFoundException;
import by.bal.baldiplom.repository.CityRepository;
import by.bal.baldiplom.repository.CountryRepository;
import by.bal.baldiplom.service.ICityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService implements ICityService {
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final ModelMapper mapper;

    @Autowired
    public CityService(CityRepository cityRepository, CountryRepository countryRepository, ModelMapper mapper) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ReadCityDto> getAllCities() {
        return cityRepository.findAll().stream()
                .map(c -> mapper.map(c, ReadCityDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReadCityDto getCityById(int id) {
        City city = cityRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return mapper.map(city, ReadCityDto.class);
    }

    @Override
    public void editCityById(int id, WriteCityDto cityDto) {
        City city = cityRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        city.setName(cityDto.getName());
        cityRepository.save(city);
    }

    @Override
    public void deleteCityById(int id) {
        if (cityRepository.existsById(id)) cityRepository.deleteById(id);
        else throw new ResourceNotFoundException();
    }

    @Override
    public int addCity(WriteCityDto cityDto) {
        City newCity = new City();
        newCity.setName(cityDto.getName());
        newCity.setCountry(
                countryRepository.findById(cityDto.getCountryId()).orElseThrow(ResourceNotFoundException::new)
        );
        return cityRepository.saveAndFlush(newCity).getId();
    }
}
