package com.bodhi.user.controller;

import com.bodhi.user.VO.ResponseTempleteVO;
import com.bodhi.user.entity.User;
import com.bodhi.user.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private static final String USER_SERVICE = "User Service";
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser method in UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    @CircuitBreaker(name= USER_SERVICE, fallbackMethod = "userFallback")
    public ResponseTempleteVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("Inside getUserWithDepartment method in UserController");
        return userService.getUserWithDepartment(userId);
    }

    public ResponseTempleteVO userFallback(Exception e){
        ResponseTempleteVO vo = new ResponseTempleteVO();
        vo.setMessage("Department service is down ");
        return vo;
    }
}
