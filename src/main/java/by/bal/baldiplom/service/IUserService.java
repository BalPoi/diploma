package by.bal.baldiplom.service;

import by.bal.baldiplom.dto.ReadUserDto;
import by.bal.baldiplom.dto.WriteUserDto;

import java.util.List;

public interface IUserService {
    long addUser(WriteUserDto userDto);

    List<ReadUserDto> getAllUsers();

    ReadUserDto getUserById(long id);

    void editUserById(long id, WriteUserDto userDto);

    void deleteUserById(long id);
}
