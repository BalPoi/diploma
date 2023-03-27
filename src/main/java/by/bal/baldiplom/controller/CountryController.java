package by.bal.baldiplom.controller;

import by.bal.baldiplom.dto.ReadCountryDto;
import by.bal.baldiplom.dto.WriteCountryDto;
import by.bal.baldiplom.service.ICountryService;
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
@RequestMapping("/api/countries")
public class CountryController {
    private final ICountryService countryService;

    @Autowired
    public CountryController(ICountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping
    public int addCountry(@RequestBody WriteCountryDto countryDto) {
        return countryService.addCountry(countryDto);
    }

    @GetMapping
    public List<ReadCountryDto> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{id}")
    public ReadCountryDto getCountryById(@PathVariable int id) {
        return countryService.getCountryById(id);
    }

    @PutMapping("/{id}")
    public void editCountryById(@PathVariable int id,
                                @RequestBody WriteCountryDto countryDto) {
        countryService.editCountryById(id, countryDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCountryById(@PathVariable int id) {
        countryService.deleteCountryById(id);
    }
}
