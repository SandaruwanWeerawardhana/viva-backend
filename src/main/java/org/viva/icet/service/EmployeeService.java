package org.viva.icet.service;

import org.viva.icet.dto.Employee;

import java.util.List;

public interface EmployeeService {

    Boolean add(Employee employee);

    void delete(Long id);

    void update(Employee employee , Long id);

    Employee searchById(Long id);

    List<Employee> getAll();
}
