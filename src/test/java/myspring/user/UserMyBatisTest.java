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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
	
	@Test
	void sqlSession() {
		System.out.println(sessionFactory.getClass().getName());
		UserVO user = sqlSession.selectOne("userNS.selectUserById", "dooly");
		logger.debug(user);
		
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
		//.forEach(Consumer)에서 Consumer를 Lambda Expression (람다식)으로 선언하는 방식
		userList.forEach(user1 -> logger.debug(user1));
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
