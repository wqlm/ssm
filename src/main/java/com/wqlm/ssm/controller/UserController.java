package com.wqlm.ssm.controller;

import com.wqlm.ssm.dto.UserRegisterDTO;
import com.wqlm.ssm.entity.User;
import com.wqlm.ssm.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;



    @RequestMapping(value = "/get/user", method= RequestMethod.GET)
    public User getUserById(int id){
        User user =  userService.getUserById(id);
        return user;
    }


    /**
     * 注册接口
     * @param userRegisterDTO
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public boolean addUser (@RequestBody UserRegisterDTO userRegisterDTO){

        String userName = userRegisterDTO.getUserName();
        String pwd  = userRegisterDTO.getPassword();

        boolean result = userService.addUser(userName, pwd);
        return result;
    }





}
