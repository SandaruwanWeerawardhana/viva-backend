package org.viva.icet.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.viva.icet.dto.Employee;
import org.viva.icet.entity.EmployeeEntity;
import org.viva.icet.repository.EmployeeRepository;
import org.viva.icet.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository repository;
    private ModelMapper mapper;

    @Override
    public Boolean add(Employee employee) {
        if (repository.existsByEmail(employee.getEmail())) {
            return false;
        }else {
            repository.save(mapper.map(employee, EmployeeEntity.class));
            return true;
        }
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Employee employee) {
        repository.save(mapper.map(employee, EmployeeEntity.class));
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
