package org.viva.icet.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "booking")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "User ID should not be blank")
    @Size(max = 100, message = "Username must 100 characters")
    private String name;

    @NotEmpty(message = "User ID should not be blank")
    @Email
    private String email;

    @NotEmpty(message = "User ID should not be blank")
    private String department;

    private Date createAt;

    private Date updateAt;

}