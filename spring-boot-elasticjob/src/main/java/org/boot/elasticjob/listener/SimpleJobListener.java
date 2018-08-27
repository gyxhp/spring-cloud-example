package org.boot.elasticjob.listener;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;

/**
 * Created by hp on 2018/8/23.
 */
public class SimpleJobListener implements ElasticJobListener{

    public SimpleJobListener() {
    }

    @Override
    public void beforeJobExecuted(ShardingContexts shardingContexts) {
        System.out.println("----------------------------------------------->>>>>>>>>>>>>>>>>");
    }

    @Override
    public void afterJobExecuted(ShardingContexts shardingContexts) {
        System.out.println("<<<<<<<<<<<<<<<-------------------------------------------------");
    }
}
