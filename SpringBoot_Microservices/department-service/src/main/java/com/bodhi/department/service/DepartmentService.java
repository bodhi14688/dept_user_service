package com.bodhi.department.service;

import com.bodhi.department.entity.Department;
import com.bodhi.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Inside saveDepartment method of DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findByDepId(Long depId) {
        log.info("Inside findByDepId method of DepartmentService");
        return departmentRepository.findByDepId(depId);
    }
}
