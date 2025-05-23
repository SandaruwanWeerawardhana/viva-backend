package org.viva.icet.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.viva.icet.util.Department;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Long id;

    @NotEmpty(message = "User ID should not be blank")
    @Size(max = 100, message = "Username must 100 characters")
    private String name;

    @NotEmpty(message = "User ID should not be blank")
    @Email
    private String email;

    @NotNull(message = "User ID should not be blank")
    private Department department;

    private Date createAt;

    private Date updateAt;

}