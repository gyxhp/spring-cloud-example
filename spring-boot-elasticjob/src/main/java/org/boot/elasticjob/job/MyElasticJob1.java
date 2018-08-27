package org.boot.elasticjob.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.springframework.stereotype.Service;

@Service
public class MyElasticJob1 implements SimpleJob {
    @Override
    public void execute(ShardingContext shardingContext) {
        //打印出任务相关信息，JobParameter用于传递任务的ID
//        log.info("任务名：{}, 片数：{}, id={}", shardingContext.getJobName(), shardingContext.getShardingTotalCount(),
//                shardingContext.getJobParameter());
//        System.out.println(String.format("任务名：{%s}, 片数：{%d},当前片数：%d  , id=%s", shardingContext.getJobName(), shardingContext.getShardingTotalCount(),
//                shardingContext.getShardingItem(),shardingContext.getJobParameter()));


        System.out.println(String.format("------Thread ID: %s, 任务总片数: %s, " +
                        "当前分片项: %s.当前参数: %s,"+
                        "当前任务名称: %s.当前任务参数: %s"
                ,
                Thread.currentThread().getId(),
                shardingContext.getShardingTotalCount(),
                shardingContext.getShardingItem(),
                shardingContext.getShardingParameter(),
                shardingContext.getJobName(),
                shardingContext.getJobParameter()

        ));
    }
}
