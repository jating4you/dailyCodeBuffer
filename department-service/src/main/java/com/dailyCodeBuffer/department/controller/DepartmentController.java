package com.dailyCodeBuffer.department.controller;

import com.dailyCodeBuffer.department.entity.Department;
import com.dailyCodeBuffer.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping(value="/",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Department saveDepartment(@RequestBody Department department) {
        log.info("Inside DepartmentController with  savedepartment method.");
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/{id}")
    public Department findByDepartmentId(@PathVariable("id") Long departmentid) {
        log.info("Inside DepartmentController with  findDepartmentById method.");
        return departmentService.findByDepartmentId(departmentid);
    }

}
