package by.bal.baldiplom.controller;

import by.bal.baldiplom.dto.ReadCityDto;
import by.bal.baldiplom.dto.WriteCityDto;
import by.bal.baldiplom.service.ICityService;
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
@RequestMapping("/api/cities")
public class CityController {
    private final ICityService cityService;
    @Autowired
    public CityController(ICityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    public int addCity(@RequestBody WriteCityDto cityDto) {
        return cityService.addCity(cityDto);
    }

    @GetMapping
    public List<ReadCityDto> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/{id}")
    public ReadCityDto getCityById(@PathVariable int id) {
        return cityService.getCityById(id);
    }

    @PutMapping("/{id}")
    public void editCityById(@PathVariable int id,
                             @RequestBody WriteCityDto cityDto) {
        cityService.editCityById(id, cityDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCityById(@PathVariable int id) {
        cityService.deleteCityById(id);
    }
}
