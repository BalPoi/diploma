package by.bal.baldiplom.service;

import by.bal.baldiplom.dto.ReadVendorDto;
import by.bal.baldiplom.dto.WriteVendorDto;

import java.util.List;

public interface IVendorService {
    List<ReadVendorDto> getAllVendors();

    ReadVendorDto getVendorById(int id);

    void editVendorById(int id, WriteVendorDto vendorDto);

    void deleteVendorById(int id);

    int addVendor(WriteVendorDto vendorDto);
}
