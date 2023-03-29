package by.bal.baldiplom.service.impl;

import by.bal.baldiplom.dto.ReadScooterDto;
import by.bal.baldiplom.dto.WriteScooterDto;
import by.bal.baldiplom.enity.Scooter;
import by.bal.baldiplom.enity.Status;
import by.bal.baldiplom.exception.ResourceNotFoundException;
import by.bal.baldiplom.repository.ScooterModelRepository;
import by.bal.baldiplom.repository.ScooterRepository;
import by.bal.baldiplom.service.IScooterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScooterService implements IScooterService {
    private final ScooterRepository scooterRepository;
    private final ScooterModelRepository modelRepository;
    private final ModelMapper mapper;

    @Autowired
    public ScooterService(ScooterRepository scooterRepository, ScooterModelRepository modelRepository, ModelMapper mapper) {
        this.scooterRepository = scooterRepository;
        this.modelRepository = modelRepository;
        this.mapper = mapper;
    }

    @Override
    public int addScooter(WriteScooterDto scooterDto) {
        var newScooter = new Scooter();
        newScooter.setSerialNumber(scooterDto.getSerialNumber());
        newScooter.setModel(
                modelRepository.findById(scooterDto.getModelId()).orElseThrow(ResourceNotFoundException::new)
        );
        newScooter.setStatus(Status.INACTIVE);

        return scooterRepository.saveAndFlush(newScooter).getId();
    }

    @Override
    public List<ReadScooterDto> getAllScooters() {
        return scooterRepository.findAll().stream()
                .map(s -> mapper.map(s, ReadScooterDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReadScooterDto getScooterById(int id) {
        var scooter = scooterRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return mapper.map(scooter, ReadScooterDto.class);
    }

    @Override
    public void editScooterById(int id, WriteScooterDto scooterDto) {
        var scooter = scooterRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        if (scooter.getModel().getId() != scooterDto.getModelId()) {
            var model = modelRepository.findById(scooterDto.getModelId())
                    .orElseThrow(ResourceNotFoundException::new);
            scooter.setModel(model);
        }
        scooter.setSerialNumber(scooterDto.getSerialNumber());

        scooterRepository.save(scooter);
    }

    @Override
    public void deleteScooterById(int id) {
        if (scooterRepository.existsById(id)) scooterRepository.deleteById(id);
        else throw new ResourceNotFoundException();
    }
}
