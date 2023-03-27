package by.bal.baldiplom.service.impl;

import by.bal.baldiplom.dto.ReadVendorDto;
import by.bal.baldiplom.dto.WriteVendorDto;
import by.bal.baldiplom.enity.Vendor;
import by.bal.baldiplom.exception.ResourceNotFoundException;
import by.bal.baldiplom.repository.VendorRepository;
import by.bal.baldiplom.service.IVendorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorService implements IVendorService {
    private final VendorRepository vendorRepository;
    private final ModelMapper mapper;

    @Autowired
    public VendorService(VendorRepository vendorRepository, ModelMapper mapper) {
        this.vendorRepository = vendorRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ReadVendorDto> getAllVendors() {
        return vendorRepository.findAll().stream()
                .map(v -> mapper.map(v, ReadVendorDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReadVendorDto getVendorById(int id) {
        Vendor vendor = vendorRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return mapper.map(vendor, ReadVendorDto.class);
    }

    @Override
    public void editVendorById(int id, WriteVendorDto vendorDto) {
        Vendor vendor = vendorRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        vendor.setName(vendorDto.getName());
        vendorRepository.save(vendor);
    }

    @Override
    public void deleteVendorById(int id) {
        vendorRepository.deleteById(id);
    }

    @Override
    public int addVendor(WriteVendorDto vendorDto) {
        Vendor newVendor = mapper.map(vendorDto, Vendor.class);
        return vendorRepository.saveAndFlush(newVendor).getId();
    }
}
