package by.bal.baldiplom.controller;

import by.bal.baldiplom.dto.ReadScooterModelDto;
import by.bal.baldiplom.dto.WriteScooterModelDto;
import by.bal.baldiplom.service.IScooterModelService;
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
@RequestMapping("/api/models")
public class ScooterModelController {
    private final IScooterModelService modelService;

    @Autowired
    public ScooterModelController(IScooterModelService modelService) {
        this.modelService = modelService;
    }

    @PostMapping
    public int addScooterModel(@RequestBody WriteScooterModelDto modelDto) {
        return modelService.addScooterModel(modelDto);
    }

    @GetMapping
    public List<ReadScooterModelDto> getAllScooterModels() {
        return modelService.getAllScooterModels();
    }

    @GetMapping("/{id}")
    public ReadScooterModelDto getScooterModelById(@PathVariable int id) {
        return modelService.getScooterModelById(id);
    }

    @PutMapping("/{id}")
    public void editScooterModelById(@PathVariable int id,
                                     @RequestBody WriteScooterModelDto modelDto) {
        modelService.editScooterModelById(id, modelDto);
    }

    @DeleteMapping("/{id}")
    public void deleteScooterModelById(@PathVariable int id) {
        modelService.deleteScooterModelById(id);
    }
}
