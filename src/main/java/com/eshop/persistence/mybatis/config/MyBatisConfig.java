package com.eshop.persistence.mybatis.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

@Configuration
@MapperScan("com.**.mapper")
public class MyBatisConfig {
	
	@Bean
	@Autowired
	public SqlSessionFactory mybatisSqlSessionFactoryBean(DataSource dataSource) throws Throwable {
		SqlSessionFactory sqlSessionFactory = null;
		SqlSessionFactoryBean mybatisSqlSessionFactoryBean = new SqlSessionFactoryBean();
		mybatisSqlSessionFactoryBean.setDataSource(dataSource);
		
		
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		mybatisSqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:/mybatis/mapper/*Mapper.xml"));
		
		sqlSessionFactory = mybatisSqlSessionFactoryBean.getObject();
		
		System.out.println(this.getClass().getName() + " >>> " + sqlSessionFactory);
		return sqlSessionFactory;
	}

}
