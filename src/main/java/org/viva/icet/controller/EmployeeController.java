package org.viva.icet.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.viva.icet.dto.Employee;
import org.viva.icet.service.EmployeeService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/details")
@RestController
@CrossOrigin
public class EmployeeController {
    private final EmployeeService service;

    @PostMapping("/employees")
    public Boolean addEmployee(@RequestBody @Valid Employee employee) {
        return service.add(employee);
    }

    @PutMapping("/update")
    public void updateEmployee(@RequestBody Employee employee) {
        service.update(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/employees")
    List<Employee> getAll() {
        return service.getAll();
    }
}
