package myspring.user;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.user.dao.mapper.UserMapper;
import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans-mybatis.xml")
public class UserMyBatisTest {
	protected static final Logger logger = LogManager.getLogger();
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSessionFactory sessionFactory;
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	UserService userService;
	
	@Test
	void service() {
		userService.insertUser(new UserVO("boot", "아임부트", "남", "부산"));
		UserVO user = userService.getUser("boot");
		logger.debug(user);
	}
	
	@Test @Disabled
	void mapper() {
		UserVO user = userMapper.selectUserById("gildong");
		logger.debug(user);
	}
	
	
	@Test @Disabled
	void userMapper() {
		UserVO user = sqlSession.selectOne("userNS.selectUserById", "dooly");
		logger.debug(user);
		
	}
	
	@Test @Disabled
	void sqlSession() {
		System.out.println(sessionFactory.getClass().getName());
		
		//Anonymous Inner Class (익명 내부 클래스)
		List<UserVO> userList = sqlSession.selectList("userNS.selectUserList");  //List<UserVO>
		//기존의 For Loop
		for (UserVO userVO : userList) {
			logger.debug(userVO);
		}
		//.forEach(Consumer)에서 Consumer를 Anonymous Inner class 형태로 선언하는 방식
		userList.forEach(new Consumer<UserVO>() {
			@Override
			public void accept(UserVO user) {
				logger.debug(user);				
			}
		});
		
		//Consumer 추상메서드 void accept(T t)
		//.forEach(Consumer)에서 Consumer를 Lambda Expression (람다식)으로 선언하는 방식
		userList.forEach(user1 -> System.out.println(user1));
		//.forEach(Consumer)에서 Consumer를 Method Reference 으로 선언하는 방식
		userList.forEach(System.out::println);
	}
	
	
	@Test
	void connection() {
		try {
			Connection connection = dataSource.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();
			logger.debug("DB URL = " + metaData.getURL());
			logger.debug("DB Username = " + metaData.getUserName());
			logger.debug("DB Vendor Name = " + metaData.getDatabaseProductName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
