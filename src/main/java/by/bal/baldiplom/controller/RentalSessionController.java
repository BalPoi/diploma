package by.bal.baldiplom.controller;

import by.bal.baldiplom.dto.ReadRentalSessionDto;
import by.bal.baldiplom.dto.WriteRentalSessionDto;
import by.bal.baldiplom.service.IRentalSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class RentalSessionController {
    private final IRentalSessionService sessionService;

    @Autowired
    public RentalSessionController(IRentalSessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping
    public long addRentalSession(@RequestBody WriteRentalSessionDto sessionDto) {
        return sessionService.addRentalSession(sessionDto);
    }

    @GetMapping
    public List<ReadRentalSessionDto> getAllRentalSessions() {
        return sessionService.getAllRentalSessions();
    }

    @GetMapping("/{id}")
    public ReadRentalSessionDto getRentalSessionById(@PathVariable long id) {
        return sessionService.getRentalSessionById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRentalSessionById(@PathVariable long id) {
        sessionService.deleteRentalSessionById(id);
    }
}
