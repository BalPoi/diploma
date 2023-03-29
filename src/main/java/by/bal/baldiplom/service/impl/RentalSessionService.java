package by.bal.baldiplom.service.impl;

import by.bal.baldiplom.dto.ReadRentalSessionDto;
import by.bal.baldiplom.dto.WriteRentalSessionDto;
import by.bal.baldiplom.enity.RentalSession;
import by.bal.baldiplom.exception.ResourceNotFoundException;
import by.bal.baldiplom.repository.ParkingStationRepository;
import by.bal.baldiplom.repository.RentalSessionRepository;
import by.bal.baldiplom.repository.ScooterRepository;
import by.bal.baldiplom.repository.UserRepository;
import by.bal.baldiplom.service.IRentalSessionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalSessionService implements IRentalSessionService {
    private final RentalSessionRepository sessionRepository;
    private final UserRepository userRepository;
    private final ScooterRepository scooterRepository;
    private final ParkingStationRepository stationRepository;
    private final ModelMapper mapper;

    @Autowired
    public RentalSessionService(RentalSessionRepository sessionRepository, UserRepository userRepository, ScooterRepository scooterRepository, ParkingStationRepository stationRepository, ModelMapper mapper) {
        this.sessionRepository = sessionRepository;
        this.userRepository = userRepository;
        this.scooterRepository = scooterRepository;
        this.stationRepository = stationRepository;
        this.mapper = mapper;
    }

    @Override
    public long addRentalSession(WriteRentalSessionDto sessionDto) {
        var newSession = new RentalSession();
        var user = userRepository.findById(sessionDto.getUserId()).orElseThrow(ResourceNotFoundException::new);
        var scooter = scooterRepository.findById(sessionDto.getScooterId()).orElseThrow(ResourceNotFoundException::new);
        var station = stationRepository.findById(sessionDto.getScooterId()).orElseThrow(ResourceNotFoundException::new);

        newSession.setUser(user);
        newSession.setScooter(scooter);
        newSession.setBeginTime(LocalDateTime.now());
        newSession.setBeginStation(station);

        return sessionRepository.saveAndFlush(newSession).getId();
    }

    @Override
    public List<ReadRentalSessionDto> getAllRentalSessions() {
        return sessionRepository.findAll().stream()
                .map(session -> mapper.map(session, ReadRentalSessionDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReadRentalSessionDto getRentalSessionById(long id) {
        var session = sessionRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return mapper.map(session, ReadRentalSessionDto.class);
    }

    @Override
    public void deleteRentalSessionById(long id) {
        if (sessionRepository.existsById(id)) sessionRepository.deleteById(id);
        else throw new ResourceNotFoundException();
    }
}
