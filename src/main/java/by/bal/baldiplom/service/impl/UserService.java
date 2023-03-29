package by.bal.baldiplom.service.impl;

import by.bal.baldiplom.dto.ReadUserDto;
import by.bal.baldiplom.dto.WriteUserDto;
import by.bal.baldiplom.enity.Role;
import by.bal.baldiplom.enity.User;
import by.bal.baldiplom.exception.ResourceNotFoundException;
import by.bal.baldiplom.repository.UserRepository;
import by.bal.baldiplom.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public long addUser(WriteUserDto userDto) {
        var newUser = new User();
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword(userDto.getPassword());
        newUser.setFirstName(userDto.getFirstName());
        newUser.setLastName(userDto.getLastName());
        newUser.setRole(Role.CUSTOMER_ROLE);
        newUser.setActive(true);

        return userRepository.saveAndFlush(newUser).getId();
    }

    @Override
    public List<ReadUserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(u -> mapper.map(u, ReadUserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReadUserDto getUserById(long id) {
        var user = userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return mapper.map(user, ReadUserDto.class);
    }

    @Override
    public void editUserById(long id, WriteUserDto userDto) {
        var user = userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
    }

    @Override
    public void deleteUserById(long id) {
        if (userRepository.existsById(id)) userRepository.deleteById(id);
        else throw new ResourceNotFoundException();
    }
}
