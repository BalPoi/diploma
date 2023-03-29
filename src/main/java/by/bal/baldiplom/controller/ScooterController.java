package by.bal.baldiplom.controller;

import by.bal.baldiplom.dto.ReadScooterDto;
import by.bal.baldiplom.dto.WriteScooterDto;
import by.bal.baldiplom.service.IScooterService;
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
@RequestMapping("/api/scooters")
public class ScooterController {
    private final IScooterService scooterService;

    @Autowired
    public ScooterController(IScooterService scooterService) {
        this.scooterService = scooterService;
    }

    @PostMapping
    public int addScooter(@RequestBody WriteScooterDto scooterDto) {
        return scooterService.addScooter(scooterDto);
    }

    @GetMapping
    public List<ReadScooterDto> getAllScooters() {
        return scooterService.getAllScooters();
    }

    @GetMapping("/{id}")
    public ReadScooterDto getScooterById(@PathVariable int id) {
        return scooterService.getScooterById(id);
    }

    @PutMapping("/{id}")
    public void editScooter(@PathVariable int id,
                            @RequestBody WriteScooterDto scooterDto) {
        scooterService.editScooterById(id, scooterDto);
    }

    @DeleteMapping("/{id}")
    public void deleteScooterById(@PathVariable int id) {
        scooterService.deleteScooterById(id);
    }
}
