package org.boot.elasticjob.config;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Zookeeper 配置管理类
 * Created by hp on 2018/8/13.
 */
@Configuration
@ConditionalOnExpression("'${regCenter.serverlists}'.length() > 0")
public class JobRegistryCenterConfig {

    @Bean(initMethod = "init")
    public ZookeeperRegistryCenter regCenter(@Value("${regCenter.serverlists}") final String serverList, @Value("${regCenter.namespace}") final String namespace) {
        return new ZookeeperRegistryCenter(new ZookeeperConfiguration(serverList, namespace));
    }


//    @Bean
//    public HikariDataSource hikariDataSource(@Value("datasource") DataSource datasource) {
//        HikariDataSource hikariDataSource = new HikariDataSource();
//        hikariDataSource.setDataSource(datasource);
//        return new HikariDataSource();
//    }

}
