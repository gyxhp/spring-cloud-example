package org.boot.elasticjob.service.impl;

import org.boot.elasticjob.service.UserService;
import org.boot.elasticjob.mapper.UserMapper;
import org.boot.elasticjob.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 2018/8/22.
 */
@Service
public class UserServiceimpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public int insert(User user) {
        int insert = userMapper.insert(user);
        return insert;
    }

    @Override
    public int insertList() {
        List<User> list = new ArrayList<>();
        System.out.println("开始准备数据！");
        for (int i = 0; i < 10; i++) {
            User user = new User(i,"张"+i,"密"+i,"phone"+i);
            list.add(user);
        }
        System.out.println("数据准备完成！开始存储数据！");
        for (User user:list) {
            insert(user);
        }
        System.out.println("数据存储完成！");
        return 0;
    }

    @Override
    public List<User> selectAll() {
        List<User> users = userMapper.selectAll();
        return users;
    }
}
