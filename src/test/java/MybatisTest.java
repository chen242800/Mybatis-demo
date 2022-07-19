import Mapper.BrandMapper;
import Mapper.UserMapper;
import POJO.Brand;
import POJO.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MybatisTest {

    @Test
    public void TestSelectAll() throws IOException {
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession 对象，执行sql
        SqlSession sqlSession= sessionFactory.openSession();

        //3. 执行sql
        //List<User> users = sqlSession.selectList("test.selectAll");
        //3.1 获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectAll();

        sqlSession.close();
        System.out.println(brands);


    }

    @Test
    public void TestSelectById() throws IOException {
        int id = 1;
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession 对象，执行sql
        SqlSession sqlSession= sessionFactory.openSession();

        //3. 执行sql
        //List<User> users = sqlSession.selectList("test.selectAll");
        //3.1 获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectById(id);

        sqlSession.close();
        System.out.println(brands);


    }

    @Test
    public void TestSelectByCondition() throws IOException {
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        //处理参数
        companyName = "%" +companyName +"%";
        brandName = "%" +brandName +"%";

        //brand 为参数
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);

        //map为参数
        Map map = new HashMap();
        map.put("status", status);
        map.put("companyName", companyName);
        map.put("brandName", brandName);

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession 对象，执行sql
        SqlSession sqlSession= sessionFactory.openSession();

        //3. 执行sql
        //List<User> users = sqlSession.selectList("test.selectAll");
        //3.1 获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectByCondition(status,companyName,brandName);
        List<Brand> brands2 = brandMapper.selectByCondition(brand);
        List<Brand> brands3 = brandMapper.selectByCondition(map);

        sqlSession.close();
        System.out.println(brands);
        System.out.println(brands2);
        System.out.println(brands3);


    }

    @Test
    public void TestSelectByConditionSingle() throws IOException {
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        //处理参数
        companyName = "%" +companyName +"%";
        brandName = "%" +brandName +"%";

        //brand 为参数
        Brand brand = new Brand();
        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);

        //map为参数
        Map map = new HashMap();
        map.put("status", status);
        map.put("companyName", companyName);
        map.put("brandName", brandName);

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession 对象，执行sql
        SqlSession sqlSession= sessionFactory.openSession();

        //3. 执行sql
        //List<User> users = sqlSession.selectList("test.selectAll");
        //3.1 获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectByCondition(status,companyName,brandName);
        List<Brand> brands2 = brandMapper.selectByCondition(brand);
        List<Brand> brands3 = brandMapper.selectByCondition(map);

        sqlSession.close();
//        System.out.println(brands);
        System.out.println(brands2);
//        System.out.println(brands3);


    }

    @Test
    public void TestAdd() throws IOException {
        int status = 1;
        String companyName = "波导";
        String brandName = "波导";
        String description = "手机中的战斗机";
        int order = 100;


        //brand 为参数
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(order);



        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession 对象，执行sql
        SqlSession sqlSession= sessionFactory.openSession();

        //3. 执行sql
        //List<User> users = sqlSession.selectList("test.selectAll");
        //3.1 获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.add(brand);

        //提交事务
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void TestUpdate() throws IOException {
        int status = 1;
        String companyName = "波导";
        String brandName = "波导";
        String description = "手机中的战斗机2222222";
        int order = 100;
        int id= 5;


        //brand 为参数
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(order);
        brand.setId(id);



        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession 对象，执行sql
        SqlSession sqlSession= sessionFactory.openSession();

        //3. 执行sql
        //List<User> users = sqlSession.selectList("test.selectAll");
        //3.1 获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        int count = brandMapper.update(brand);
        System.out.println(count);

        //提交事务
        sqlSession.commit();
        sqlSession.close();

    }


    @Test
    public void TestDeleteById() throws IOException {

        int id= 5;

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession 对象，执行sql
        SqlSession sqlSession= sessionFactory.openSession();

        //3. 执行sql
        //List<User> users = sqlSession.selectList("test.selectAll");
        //3.1 获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.deleteById(id);

        //提交事务
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void TestDeleteByIds() throws IOException {

        int[] ids= {2,3,5};

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession 对象，执行sql
        SqlSession sqlSession= sessionFactory.openSession();

        //3. 执行sql
        //List<User> users = sqlSession.selectList("test.selectAll");
        //3.1 获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.deleteByIds(ids);

        //提交事务
        sqlSession.commit();
        sqlSession.close();

    }
}
