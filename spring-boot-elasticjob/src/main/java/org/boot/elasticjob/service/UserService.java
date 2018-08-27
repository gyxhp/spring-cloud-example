package org.boot.elasticjob.service;

import org.boot.elasticjob.entity.User;

import java.util.List;

/**
 * Created by hp on 2018/8/22.
 */
public interface UserService {
    int insert(User user);

    int insertList();

    List<User> selectAll();
}
