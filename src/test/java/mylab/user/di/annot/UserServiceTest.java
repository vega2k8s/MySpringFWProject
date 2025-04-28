package mylab.user.di.annot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {
    
    @Autowired
    private UserService userService;
    
    @Test
    public void testUserService() {
        assertNotNull(userService);
        
        // UserRepository 확인
        //userService.getUserRepository() => UserRepository
        assertNotNull(userService.getUserRepository());
        //userService.getUserRepository().getDbType() ==> String 타입은 값은 MySQL
        assertEquals("MySQL", userService.getUserRepository().getDbType());
        
        // SecurityService(어노테이션으로 주입) 확인
        assertNotNull(userService.getSecurityService());
        
        // 기능 테스트
        assertTrue(userService.registerUser("user1", "홍길동", "password123")); //true
        assertFalse(userService.registerUser("user2", "김철수", "")); //false
    }
}