package org.boot.elasticjob.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.event.rdb.JobEventRdbConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.boot.elasticjob.job.MyElasticJob;
import org.boot.elasticjob.job.MyElasticJob1;
import org.boot.elasticjob.listener.ElasticJobListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * job配置管理类
 *
 * @author luoliang
 * @date 2018/4/9
 **/
@Configuration
public class ElasticJobConfig {

    @Autowired
    private ZookeeperRegistryCenter regCenter;

    @Resource
    MyElasticJob myElasticJob;

    @Resource
    MyElasticJob1 myElasticJob1;

    @Resource
    private DruidDataSource dataSource;


    @Bean(initMethod = "init")
    public JobScheduler simpleJobScheduler( @Value("${stockJob.cron}") final String cron, @Value("${stockJob.shardingTotalCount}") final int shardingTotalCount, @Value("${stockJob.shardingItemParameters}") final String shardingItemParameters) {
        return new SpringJobScheduler(myElasticJob, regCenter, getLiteJobConfiguration(myElasticJob.getClass(), cron, shardingTotalCount, shardingItemParameters),jobEventConfiguration(),elasticJobListener());
    }

//    @Bean(initMethod = "init")
//    public JobScheduler simpleJobScheduler1( @Value("${stockJob1.cron}") final String cron, @Value("${stockJob1.shardingTotalCount}") final int shardingTotalCount, @Value("${stockJob1.shardingItemParameters}") final String shardingItemParameters) {
//        return new SpringJobScheduler(myElasticJob1, regCenter, getLiteJobConfiguration(myElasticJob1.getClass(), cron, shardingTotalCount, shardingItemParameters));
//    }

    /**
     * 将作业运行的痕迹进行持久化到DB
     *
     * @return
     */
    @Bean
    public JobEventConfiguration jobEventConfiguration() {
        return new JobEventRdbConfiguration(dataSource);
    }

    @Bean
    public ElasticJobListener elasticJobListener() {
        return new ElasticJobListener(5000L, 10000L);
//        return new SimpleJobListener();
    }


    /**
     *@Description  任务配置类
     */
    private LiteJobConfiguration getLiteJobConfiguration(final Class<? extends SimpleJob> jobClass,
                                                         final String cron,
                                                         final int shardingTotalCount,
                                                         final String shardingItemParameters){


        return LiteJobConfiguration
                .newBuilder(
                        new SimpleJobConfiguration(
                                JobCoreConfiguration.newBuilder(
                                        jobClass.getName(),cron,shardingTotalCount)
                                        .shardingItemParameters(shardingItemParameters)
                                        .build()
                                ,jobClass.getCanonicalName()
                        )
                )
                .overwrite(true)
                .build();

    }
}
