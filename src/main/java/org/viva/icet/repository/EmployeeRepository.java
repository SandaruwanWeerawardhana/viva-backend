package org.viva.icet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.viva.icet.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
    boolean existsByEmail(String email);
}
