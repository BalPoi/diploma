package by.bal.baldiplom.service.impl;

import by.bal.baldiplom.dto.ReadScooterModelDto;
import by.bal.baldiplom.dto.WriteScooterModelDto;
import by.bal.baldiplom.enity.ScooterModel;
import by.bal.baldiplom.exception.ResourceNotFoundException;
import by.bal.baldiplom.repository.ScooterModelRepository;
import by.bal.baldiplom.repository.VendorRepository;
import by.bal.baldiplom.service.IScooterModelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScooterModelService implements IScooterModelService {
    private final ScooterModelRepository modelRepository;
    private final VendorRepository vendorRepository;
    private final ModelMapper mapper;

    @Autowired
    public ScooterModelService(ScooterModelRepository modelRepository, ModelMapper mapper, VendorRepository vendorRepository) {
        this.modelRepository = modelRepository;
        this.vendorRepository = vendorRepository;
        this.mapper = mapper;
    }

    @Override
    public int addScooterModel(WriteScooterModelDto modelDto) {
        ScooterModel newModel = new ScooterModel();
        newModel.setName(modelDto.getName());
        newModel.setVendor(vendorRepository.findById(modelDto.getVendorId()).orElseThrow(ResourceNotFoundException::new));
        return modelRepository.saveAndFlush(newModel).getId();
    }

    @Override
    public List<ReadScooterModelDto> getAllScooterModels() {
        return modelRepository.findAll().stream()
                .map(m -> mapper.map(m, ReadScooterModelDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReadScooterModelDto getScooterModelById(int id) {
        var model = modelRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return mapper.map(model, ReadScooterModelDto.class);
    }

    @Override
    public void editScooterModelById(int id, WriteScooterModelDto modelDto) {
        var model = modelRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        if (model.getVendor().getId() != modelDto.getVendorId()) {
            var newVendor = vendorRepository.findById(modelDto.getVendorId()).orElseThrow(ResourceNotFoundException::new);
            model.setVendor(newVendor);
        }
        model.setName(modelDto.getName());

        modelRepository.save(model);
    }

    @Override
    public void deleteScooterModelById(int id) {
        if (modelRepository.existsById(id)) modelRepository.deleteById(id);
        else throw new ResourceNotFoundException();
    }
}
