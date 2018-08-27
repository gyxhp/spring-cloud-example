package org.boot.elasticjob.listener;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.AbstractDistributeOnceElasticJobListener;
import org.apache.log4j.Logger;
//import org.boot.elasticjob.mapper.TaskRepository;
//import org.boot.elasticjob.entity.JobTask;

import javax.annotation.Resource;


/**
 * 实现分布式任务监听器
 * 如果任务有分片，分布式监听器会在总的任务开始前执行一次，结束时执行一次
 * 可用于执行结束的一系列操作，如，删除数据，修改状态等等
 **/
public class ElasticJobListener extends AbstractDistributeOnceElasticJobListener {


    public ElasticJobListener(long startedTimeoutMilliseconds, long completedTimeoutMilliseconds) {
        super(startedTimeoutMilliseconds, completedTimeoutMilliseconds);
    }

    @Override
    public void doBeforeJobExecutedAtLastStarted(ShardingContexts shardingContexts) {
        System.out.println(String.format("分布式监听器监听---->开始调度任务[%s]", shardingContexts.getJobName()));
    }

    @Override
    public void doAfterJobExecutedAtLastCompleted(ShardingContexts shardingContexts) {
//        //任务执行完成后更新状态为已执行
//        JobTask jobTask = taskRepository.findOne(Long.valueOf(shardingContexts.getJobParameter()));
//        jobTask.setStatus(1);
//        taskRepository.save(jobTask);
        System.out.println(String.format("分布式监听器监听---->结束调度任务[%s]", shardingContexts.getJobName()));
}
}
