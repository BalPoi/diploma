package by.bal.baldiplom.controller;

import by.bal.baldiplom.dto.ReadVendorDto;
import by.bal.baldiplom.dto.WriteVendorDto;
import by.bal.baldiplom.service.IVendorService;
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
@RequestMapping("/api/vendors")
public class VendorController {
    private final IVendorService vendorService;

    @Autowired
    public VendorController(IVendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PostMapping
    public int addVendor(@RequestBody WriteVendorDto vendorDto) {
        return vendorService.addVendor(vendorDto);
    }

    @GetMapping
    public List<ReadVendorDto> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @GetMapping("/{id}")
    public ReadVendorDto getVendorById(@PathVariable int id) {
        return vendorService.getVendorById(id);
    }

    @PutMapping("/{id}")
    public void editVendorById(@PathVariable int id,
                               @RequestBody WriteVendorDto vendorDto) {
        vendorService.editVendorById(id, vendorDto);
    }

    @DeleteMapping("/{id}")
    public void deleteVendorById(@PathVariable int id) {
        vendorService.deleteVendorById(id);
    }
}
