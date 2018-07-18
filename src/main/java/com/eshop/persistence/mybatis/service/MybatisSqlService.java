package com.eshop.persistence.mybatis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class MybatisSqlService {
	@Resource
	SqlSession sqlSession = null;
	
	public List query() {
		String sqlId = "order.query";
		
		System.out.println("sqlSession="+sqlSession);
		
		Map map = new HashMap();
		
		List list = sqlSession.selectList(sqlId, map);
		System.out.println("list="+list);
		
		return list;
	}
}
