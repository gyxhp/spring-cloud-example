package org.boot.elasticjob.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;


/**
 * Created by Admin on 2018/12/7.
 */
@Configuration
//@MapperScan(basePackages = "mapper的文件路径",sqlSessionTemplateRef = "AAASqlSessionTemplate")
public class DataSourceAAAConfigure {
//    @Value("${配置文件key}")
    private String url;
    private String driverClassName;
    private String userName;


    /**
     * 数据源设置
     * @return
     */
    @Bean(name = "AAADataSource")
//    @Primary
//    @ConfigurationProperties(prefix = "spring.datasource.mcpch")
    public DataSource setDataSource(){
        DataSource dataSource = new DataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setMaxActive(150);
        dataSource.setInitialSize(20);
        dataSource.setMinIdle(20);
        dataSource.setMaxWait(5000);
        dataSource.setTestOnBorrow(true);
        dataSource.setTestOnReturn(true);
        dataSource.setValidationQuery("select 1");//sql查询，用来验证从连接池取出的连接
        // 指明连接是否空闲连接回收期（如果有）进行校验，如果监测失败，则连接将从连接池去除
        dataSource.setTestWhileIdle(true);
        // 在空闲连接回收器线程运行期间休眠的时间值，以毫秒为单位，一般比minEvictableTimeMillis小
        dataSource.setTimeBetweenEvictionRunsMillis(300000);
        // 每次空闲连接回收线程（如果有）运行时检查的连接数量，最好和maxActive一致
        dataSource.setNumTestsPerEvictionRun(50);
        // 连接池中连接，在时间段内一直空闲，被逐出连接池的时间（1000*60*60）,以毫秒为单位
        dataSource.setMinEvictableIdleTimeMillis(3600000);
        return dataSource;
    }

    /**
     * mybatis 所需的三个对象设置
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "AAATransactionManager")
//    @Primary
    public DataSourceTransactionManager setDataSourceTransactionManager(@Qualifier("AAADataSource") DataSource dataSource) throws Exception{
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "AAASqlSessionFactory")
//    @Primary
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("AAADataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }
    @Bean(name = "AAASqlSessionTemplate")
//    @Primary
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("AAASqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
