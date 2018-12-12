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


    /**
     * 初始化job，如有多个job，就另外初始化多个Bean
     *
     * @param cron
     * @param shardingTotalCount
     * @param shardingItemParameters
     * @return
     */
    @Bean(initMethod = "init")
    public JobScheduler simpleJobScheduler(@Value("${stockJob.cron}") final String cron, @Value("${stockJob.shardingTotalCount}") final int shardingTotalCount, @Value("${stockJob.shardingItemParameters}") final String shardingItemParameters) {
        return new SpringJobScheduler(myElasticJob, regCenter, getLiteJobConfiguration(myElasticJob.getClass(), cron, shardingTotalCount, shardingItemParameters), jobEventConfiguration(), elasticJobListener());
    }

    /**
     * 将作业运行的痕迹（日志信息）进行持久化到DB，可在console控制台中查看
     *
     * @return
     */
    @Bean
    public JobEventConfiguration jobEventConfiguration() {
        return new JobEventRdbConfiguration(dataSource);
    }

    /**
     * 初始化监听器，用于监听job的结束和开始
     *
     * @return
     */
    @Bean
    public ElasticJobListener elasticJobListener() {
        return new ElasticJobListener(5000L, 10000L);
//        return new SimpleJobListener();
    }


    /**
     * @Description 任务配置类
     * 如有详细配置，可使用JobCoreConfiguration另外的构造器，这里选取了必要的配置
     */
    private LiteJobConfiguration getLiteJobConfiguration(final Class<? extends SimpleJob> jobClass,
                                                         final String cron,
                                                         final int shardingTotalCount,
                                                         final String shardingItemParameters) {
        return LiteJobConfiguration
                .newBuilder(
                        new SimpleJobConfiguration(
                                JobCoreConfiguration.newBuilder(
                                        jobClass.getName(), cron, shardingTotalCount)
                                        .shardingItemParameters(shardingItemParameters)
                                        .build()
                                , jobClass.getCanonicalName()
                        )
                )
                .overwrite(true)
                .build();

    }

    /**
     * 完整的配置
     * @param jobClass                       job.class
     * @param cron                           cron表达式（定时）
     * @param shardingTotalCount             总的分片数
     * @param shardingItemParameters         分片的序列号和参数 0=A，0=B
     * @param jobParameter                   自定义参数
     * @param failover                       是否开启任务失效转移（默认false）
     * @param misfire                        是否开启错过任务重新执行（默认true）
     * @param monitorException               监控作业运行状态（建议运行时间或者间隔时间较长的开启）
     * @return
     */
    private LiteJobConfiguration getALlLiteJobConfiguration(final Class<? extends SimpleJob> jobClass,
                                                            final String cron,
                                                            final int shardingTotalCount,
                                                            final String shardingItemParameters,
                                                            final String jobParameter, final boolean failover, final boolean misfire, final boolean monitorException
    ) {
        return LiteJobConfiguration
                .newBuilder(
                        new SimpleJobConfiguration(
                                JobCoreConfiguration.newBuilder(jobClass.getName(), cron, shardingTotalCount)
                                        .shardingItemParameters(shardingItemParameters)
                                        .jobParameter(jobParameter)
                                        .failover(failover)
                                        .misfire(misfire)
                                        .build()
                                , jobClass.getCanonicalName()
                        )
                )
                .monitorExecution(monitorException)
                .overwrite(true)
                .build();

    }
}
