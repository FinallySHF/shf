package com.shf.shf.core.datasource;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

/**
 * 
 * <p><b>多数据源配置</b></p>
 * @author Chao.yy  #2018年06月07日 下午4:50:00
 * @version V1.0
 * ddxx.db.multipleSource.enabled = true 则初始化
 */
public class MultipleDataSourceConfigurer {
    @Autowired
    private MybatisProperties properties;
    @Autowired
    private DataSourceProperties dataSourceProperties;
     
    /**
     * 
     * <p><b>动态数据源配置</b></p>
     * @author Chao.yy  # 2018年06月07日 下午4:46:29
     * @version V1.0
     * @return
     * @throws SQLException 
     *
     */
    @Bean
    public DataSource dataSource() {
    	List<Properties> propertiesList =  dataSourceProperties.getConfigProperties();
        Map<Object, Object> dataSourceMap = new HashMap<>(propertiesList.size());
        DynamicRoutingDataSource dynamicRoutingDataSource = new DynamicRoutingDataSource();
        for (Properties properties : propertiesList) {
            DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
            dataSource.configFromPropety(properties);
            dataSourceMap.put(dataSource.getName(), dataSource);
        }
        dynamicRoutingDataSource.setDataSourceMap(dataSourceMap); 
        //设置主数据源为默认数据源
        dynamicRoutingDataSource.setDefaultTargetDataSource(dataSourceMap.get("default"));
        //设置所有数据数据源
        dynamicRoutingDataSource.setTargetDataSources(dataSourceMap);
        dynamicRoutingDataSource.afterPropertiesSet();

        //设置数据源key集合
        MultipleDataSourceContextHolder.getDataSourceKeys().addAll(dataSourceMap.keySet());
        return dynamicRoutingDataSource;
    }

    /**
     * 
     * <p><b>为SqlSessionFactoryBean配置数据源</b></p>
     * @author Chao.yy  # 2018年06月07日 下午4:45:19
     * @version V1.0
     * @return
     * @throws Exception
     *
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setMapperLocations(properties.resolveMapperLocations());
        factory.setDataSource(dataSource());
        return factory;
    }

    /**
     * 
     * <p><b>配置事务管理</b></p>
     * @author Chao.yy  # 2018年06月07日 下午4:43:55
     * @version V1.0
     * @return
     *
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

}
