package by.bal.baldiplom.service;

import by.bal.baldiplom.dto.ReadRentalSessionDto;
import by.bal.baldiplom.dto.WriteRentalSessionDto;

import java.util.List;

public interface IRentalSessionService {
    long addRentalSession(WriteRentalSessionDto sessionDto);

    List<ReadRentalSessionDto> getAllRentalSessions();

    ReadRentalSessionDto getRentalSessionById(long id);

    void deleteRentalSessionById(long id);
}
