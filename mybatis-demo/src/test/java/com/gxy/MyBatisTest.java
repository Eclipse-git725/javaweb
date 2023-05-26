package com.gxy;

import com.gxy.mapper.BrandMapper;
import com.gxy.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    @Test
    public void testSelectAll() throws IOException {
        // 1. 获取sqlSessionFactory，获取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2. 获取SqlSesiion对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 4. 执行方法
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);
        // 5. 释放资源
        sqlSession.close();
    }
}
