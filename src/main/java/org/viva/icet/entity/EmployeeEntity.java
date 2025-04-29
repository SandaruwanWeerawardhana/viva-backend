package org.viva.icet.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.viva.icet.util.Department;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee" ,uniqueConstraints = {
@UniqueConstraint(columnNames = "email")
})
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name is required")
    @Size(max = 100, message = "Username must 100 characters")
    private String name;

    @NotEmpty(message = "Email is required")
    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @NotNull(message = "not be blank")
    @Enumerated(EnumType.STRING)
    private Department department;

    private Date createAt;

    private Date updateAt;

}