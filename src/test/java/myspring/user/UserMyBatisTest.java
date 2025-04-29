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
		for (UserVO userVO : userList) {
			logger.debug(userVO);
		}
		
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
