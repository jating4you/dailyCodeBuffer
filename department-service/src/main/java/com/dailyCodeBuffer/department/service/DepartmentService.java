package com.dailyCodeBuffer.department.service;

import com.dailyCodeBuffer.department.entity.Department;
import com.dailyCodeBuffer.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Inside DepartmentService with saveDepartment method.");

        return departmentRepository.save(department);
    }

    public Department findByDepartmentId(Long departmentid) {
        log.info("Inside DepartmentService with saveDepartment method.");
        return departmentRepository.findByDepartmentId(departmentid);
    }


}
