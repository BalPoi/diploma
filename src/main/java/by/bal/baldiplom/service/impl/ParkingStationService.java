package by.bal.baldiplom.service.impl;

import by.bal.baldiplom.dto.ReadParkingStationDto;
import by.bal.baldiplom.dto.WriteParkingStationDto;
import by.bal.baldiplom.enity.Station;
import by.bal.baldiplom.exception.ResourceNotFoundException;
import by.bal.baldiplom.repository.CityRepository;
import by.bal.baldiplom.repository.ParkingStationRepository;
import by.bal.baldiplom.service.IParkingStationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingStationService implements IParkingStationService {
    private final ParkingStationRepository stationRepository;
    private final CityRepository cityRepository;
    private final ModelMapper mapper;

    @Autowired
    public ParkingStationService(ParkingStationRepository stationRepository, CityRepository cityRepository, ModelMapper mapper) {
        this.stationRepository = stationRepository;
        this.cityRepository = cityRepository;
        this.mapper = mapper;
    }

    @Override
    public int addStation(WriteParkingStationDto stationDto) {
        var newStation = new Station();
        newStation.setCity(
                cityRepository.findById(stationDto.getCityId()).orElseThrow(ResourceNotFoundException::new)
        );
        newStation.setAddress(stationDto.getAddress());
        newStation.setSlotsNumber(stationDto.getSlotsNumber());
        newStation.setFreeSlotsNumber(stationDto.getFreeSlotsNumber());

        return stationRepository.saveAndFlush(newStation).getId();
    }

    @Override
    public List<ReadParkingStationDto> getAllStations() {
        return stationRepository.findAll().stream()
                .map(s -> mapper.map(s, ReadParkingStationDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReadParkingStationDto getStationById(int id) {
        var station = stationRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return mapper.map(station, ReadParkingStationDto.class);
    }

    @Override
    public void editStation(int id, WriteParkingStationDto stationDto) {
        var station = stationRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        if (station.getCity().getId() != stationDto.getCityId()) {
            var city = cityRepository.findById(stationDto.getCityId())
                    .orElseThrow(ResourceNotFoundException::new);
            station.setCity(city);
        }
        station.setAddress(stationDto.getAddress());
        station.setFreeSlotsNumber(stationDto.getFreeSlotsNumber());
        station.setSlotsNumber(stationDto.getSlotsNumber());

        stationRepository.save(station);
    }

    @Override
    public void deleteStationById(int id) {
        if (stationRepository.existsById(id)) stationRepository.deleteById(id);
        else throw new ResourceNotFoundException();
    }
}
