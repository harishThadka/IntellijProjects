package com.microservices.userservice.service;


import com.microservices.userservice.VO.Department;
import com.microservices.userservice.VO.ResponseTemplateVO;
import com.microservices.userservice.model.User;
import com.microservices.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;


    public User saveUser(User user) {
        log.info("Inside save user of service");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDept(Long userId) {
        log.info("Inside getUserWithDept of service");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        Department dept = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDeptId(),Department.class);
        vo.setUser(user);
        vo.setDepartment(dept);
        return vo;
    }
}
