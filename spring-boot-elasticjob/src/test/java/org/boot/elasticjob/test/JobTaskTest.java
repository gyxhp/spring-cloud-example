package org.boot.elasticjob.test;

import org.boot.elasticjob.entity.User;
import org.boot.elasticjob.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author luoliang
 * @date 2018/4/10
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JobTaskTest {

    @Resource
    UserService userService;


    @Test
    public void add() {
        List<User> users = userService.selectAll();
        for (User user: users
             ) {
            System.out.println(user.getUserId());
        }
        //生成几个任务，第一任务在三分钟之后
//        Long unixTime = System.currentTimeMillis() + 60000;
//        JobTask task = new JobTask("test-msg-1", 0, unixTime);
//        taskRepository.save(task);
//        unixTime += 60000;
//        task = new JobTask("test-msg-2", 0, unixTime);
//        taskRepository.save(task);
//        unixTime += 60000;
//        task = new JobTask("test-msg-3", 0, unixTime);
//        taskRepository.save(task);
//        unixTime += 60000;
//        task = new JobTask("test-msg-4", 0, unixTime);
//        taskRepository.save(task);
    }
}
