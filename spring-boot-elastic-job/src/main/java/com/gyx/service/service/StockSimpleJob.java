package com.gyx.service.service;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * Created by hp on 2018/8/13.
 */
public class StockSimpleJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {
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
