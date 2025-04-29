package org.viva.icet.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.viva.icet.dto.Employee;
import org.viva.icet.entity.EmployeeEntity;
import org.viva.icet.repository.EmployeeRepository;
import org.viva.icet.service.EmployeeService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;
    private final ModelMapper mapper;

    @Override
    public Boolean add(Employee employee) {
        if (repository.existsByEmail(employee.getEmail())) {
            return false;
        } else {
            EmployeeEntity entity = mapper.map(employee, EmployeeEntity.class);
            entity.setCreateAt(new Date());
            entity.setUpdateAt(new Date());
            repository.save(entity);
            return true;
        }
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Employee employee, Long id) {
        EmployeeEntity existingEmployee = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with ID " + id + " not found."));

        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setUpdateAt(new Date());

        repository.save(existingEmployee);

    }

    @Override
    public Employee searchById(Long id) {
        return null;
    }

    @Override
    public List<Employee> getAll() {
        List<EmployeeEntity> entity = repository.findAll();
        List<Employee> arrayList = new ArrayList<>();
        entity.forEach(e -> arrayList.add(mapper.map(e, Employee.class)));
        return arrayList;
    }
}
