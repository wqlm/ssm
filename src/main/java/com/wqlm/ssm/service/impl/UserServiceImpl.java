package com.wqlm.ssm.service.impl;

import com.sun.tools.javac.comp.Todo;
import com.wqlm.ssm.common.util.HashAlgorithm;
import com.wqlm.ssm.common.util.RandomCode;
import com.wqlm.ssm.entity.User;
import com.wqlm.ssm.mapper.UserMapper;
import com.wqlm.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据id获取一个对象
     *
     * @param id
     * @return
     */
    public User getUserById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * 添加一个用户
     *
     * @param userName
     * @param password
     * @return
     */
    public boolean addUser(String userName, String password) {

        //得到6位 0-Z-z 的随机数 62的6次方=5百亿
        String salt = RandomCode.getRandomCode(6);
        //将密码加盐哈希
        String code = hashPassword(password, salt);

        //构建实体对象
        User user = new User();
        user.setUserName(userName);
        user.setSalt(salt);
        user.setPassword(code);
        int result = userMapper.insertSelective(user);

        return result > 0;
    }

    /**
     * 传入密码和盐，返回hash后的字符串
     *
     * @param password
     * @return
     */
    public String hashPassword(String password, String salt) {
        String code = password + salt;
        code = HashAlgorithm.sha256(code);
        return code;
    }
}
