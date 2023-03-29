package by.bal.baldiplom.service.impl;

import by.bal.baldiplom.dto.ReadCountryDto;
import by.bal.baldiplom.dto.WriteCountryDto;
import by.bal.baldiplom.enity.Country;
import by.bal.baldiplom.exception.ResourceNotFoundException;
import by.bal.baldiplom.repository.CountryRepository;
import by.bal.baldiplom.service.ICountryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService implements ICountryService {
    private final CountryRepository countryRepository;
    private final ModelMapper mapper;

    @Autowired
    public CountryService(CountryRepository countryRepository, ModelMapper mapper) {
        this.countryRepository = countryRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ReadCountryDto> getAllCountries() {
        return countryRepository.findAll().stream()
                .map(c -> mapper.map(c, ReadCountryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReadCountryDto getCountryById(int id) {
        Country country = countryRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return mapper.map(country, ReadCountryDto.class);
    }

    @Override
    public void editCountryById(int id, WriteCountryDto countryDto) {
        Country country = countryRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        country.setName(countryDto.getName());
        countryRepository.save(country);
    }

    @Override
    public void deleteCountryById(int id) {
        if (countryRepository.existsById(id)) countryRepository.deleteById(id);
        else throw new ResourceNotFoundException();
    }

    @Override
    public int addCountry(WriteCountryDto countryDto) {
        Country newCountry = new Country();
        newCountry.setName(countryDto.getName());
        return countryRepository.saveAndFlush(newCountry).getId();
    }
}
