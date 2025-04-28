package mylab.user.di.annot;

import org.springframework.stereotype.Service;

@Service //@Component 와 같음
public class SecurityService {
    
    public boolean authenticate(String userId, String password) {
        System.out.println("인증: " + userId);
        return password != null && !password.isEmpty();
    }
    
    public boolean authorize(String userId, String resource) {
        System.out.println("권한 부여: " + userId + " for " + resource);
        return true;
    }
}