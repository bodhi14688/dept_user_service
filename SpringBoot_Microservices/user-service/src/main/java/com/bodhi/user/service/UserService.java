package com.bodhi.user.service;

import com.bodhi.user.VO.Department;
import com.bodhi.user.VO.ResponseTempleteVO;
import com.bodhi.user.entity.User;
import com.bodhi.user.repository.UserRepository;
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
        log.info("Inside saveUser method in UserService");
        return userRepository.save(user);
    }

    public ResponseTempleteVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment method in UserService");
        ResponseTempleteVO vo = new ResponseTempleteVO();
        User user = userRepository.findByUserId(userId);
        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getUserId()
                        ,Department.class);
        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }
}
