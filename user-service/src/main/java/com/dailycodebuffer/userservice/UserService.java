package com.dailycodebuffer.userservice;

import com.dailycodebuffer.VO.Department;
import com.dailycodebuffer.VO.ResponseTemplateVO;
import com.dailycodebuffer.entity.User;
import com.dailycodebuffer.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;


    public User saveUser(User user) {
        log.info("inside UserService");
        return userRepository.save(user);
    }
     //: Resolving eureka endpoints via con
    public ResponseTemplateVO getUserwithDepartment(Long userId) {
        log.info("inside UserService:getUserwithDepartment");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        log.info("with user" + user);//vdepartments
        System.out.println("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId());
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);
        System.out.println(department);

        vo.setDepartment(department);
        vo.setUser(user);

        return vo;

    }
}
