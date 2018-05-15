package com.wqlm.ssm.service;

import com.wqlm.ssm.entity.User;

public interface UserService {
    /**
     * 根据id获取一个对象
     * @param id
     * @return
     */
    User getUserById(long id);

    /**
     * 添加一个用户
     * @param userName
     * @param password
     * @return
     */
    boolean addUser(String userName, String password);
}
