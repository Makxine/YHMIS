package com.tedu.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.tedu.pojo.User;

/**
 * 测试MyBaties入门案例
 *
 */
public class HelloTest {
	
	SqlSessionFactory ssf;//声明工厂对象
	
	@Before//在执行Test之前完成
	public void init(){
		try {
			//1.获取SqlSessionFactory对象，加载配置文件
			InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
			ssf = new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void findAll() throws IOException{
		//1.获取SqlSessionFactory对象，加载配置文件
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		//2.SqlSession 执行SQL
		SqlSession session = ssf.openSession();
		//定位SQL(namespace.id)
		String statement = "helloMapper.findAll";
		List<User> list = session.selectList(statement);
		//3.解析结果
		for (User user : list) {
			System.out.println(user);
		}
		//4.释放资源
		session.close();
	}
	
	@Test
	/**
	 * 根据id查询记录
	 */
	public void findOne() throws IOException{
		//1.加载核心配置文件
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		//2.获取sqlsession
		SqlSession session = ssf.openSession();
		//定位sql(sqlspace.id)
//		User u = session.selectOne(statement,1);
		User user = new User();
		user.setId(1);
		String statement = "helloMapper.findOne";
		User u = session.selectOne(statement,user);
		//3.处理结果集
		System.out.println(u);
		//4.释放资源
		session.close();
	}
	
	@Test
	public void count() throws IOException{
		//获取sqlsession
		SqlSession session = ssf.openSession();
		//定位sql
		String statement = "helloMapper.count";
		int rows = session.selectOne(statement);
		//处理结果
		System.out.println(rows);
		//释放资源
		session.close();
	}
	
	//新增一条记录
	@Test
	public void save(){
		SqlSession session = ssf.openSession();
		String statement = "helloMapper.save";
		User user = new User();
		user.setName("王海涛");
		user.setAddr("北京");
		user.setAge(53);
		int rows = session.insert(statement, user);
		System.out.println(rows);
		session.commit();//手动提交事务
		session.close();
	}
	
	//修改指定记录
	@Test
	public void gengxin(){
		SqlSession session = ssf.openSession();
		String statement = "helloMapper.gengxin";
		User user = new User();
		user.setName("张慎政");
		user.setAddr("河南");
		user.setAge(32);
		user.setId(5);
		session.update(statement, user);
		session.commit();
		session.close();
	}
	
	//删除记录
	@Test
	public void deleteOne(){
		SqlSession session = ssf.openSession();
		String statement = "helloMapper.deleteOne";
		User user = new User();
		user.setId(5);
		session.delete(statement,user);
		session.commit();
		session.close();
				
	}
}








