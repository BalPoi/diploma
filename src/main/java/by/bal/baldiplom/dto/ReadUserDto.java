package by.bal.baldiplom.dto;

import by.bal.baldiplom.enity.Role;
import lombok.Data;

@Data
public class ReadUserDto {
    int id;
    String email;
    String firstName;
    String lastName;
    boolean active;
    Role role;
}
