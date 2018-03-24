package com.imooc.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * @author Think
 * @Configuration 配置类*
 * @EnableJpaRepositories 自动配置仓库
 * @EnableTransactionManagement 事务管理器
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.imooc.repository")
@EnableTransactionManagement
public class JPAConfig {


    /**
     * 设置数据源
     *
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 设置实体类管理工厂
     *
     * @return
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        /*jpa适配器*/
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        /*将生成sql的权利掌握在自己手中*/
        jpaVendorAdapter.setGenerateDdl(false);
        /*本地实体类配置工厂*/
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        /*设置数据源*/
        localContainerEntityManagerFactoryBean.setDataSource(dataSource());
        /*设置jpa适配器*/
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        /*设置实体类包名*/
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.imooc.entity");
        return localContainerEntityManagerFactoryBean;
    }

    /**
     * 创建事务管理对象
     * @param entityManagerFactory 传入实体工厂
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        /*创建jpa事务管理工厂*/
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        /*设置实体事务工厂*/
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

}
