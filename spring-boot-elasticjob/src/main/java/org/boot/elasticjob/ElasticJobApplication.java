package org.boot.elasticjob;

//import org.boot.elasticjob.mapper.TaskRepository;
//import org.boot.elasticjob.entity.JobTask;
//import org.boot.elasticjob.service.ElasticJobService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

/**
 * @author luoliang
 */
@SpringBootApplication
@MapperScan("org.boot.elasticjob.mapper")
public class ElasticJobApplication {
//    @Resource
//    private ElasticJobService elasticJobService;

//    @Resource
//    TaskRepository taskRepository;

    public static void main(String[] args) {
        SpringApplication.run(ElasticJobApplication.class, args);
    }

//    @Override
//    public void run(String... strings) throws Exception {
//        elasticJobService.scanAddJob();
////        Long unixTime = System.currentTimeMillis() + 60000;
////        JobTask task = new JobTask("test-msg-1", 0, unixTime);
////        taskRepository.save(task);
////        unixTime += 60000;
////        task = new JobTask("test-msg-2", 0, unixTime);
////        taskRepository.save(task);
////        unixTime += 60000;
////        task = new JobTask("test-msg-3", 0, unixTime);
////        taskRepository.save(task);
////        unixTime += 60000;
////        task = new JobTask("test-msg-4", 0, unixTime);
////        taskRepository.save(task);
//    }
}
