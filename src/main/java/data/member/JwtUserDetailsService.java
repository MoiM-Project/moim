package data.member;

import data.member.model.UserLoginRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    MemberDao memberDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {

            UserLoginRes userLoginRes = memberDao.findByEmail(username);
            System.out.println("== JwtUserDetailsService, loadUserByUsername, userLoginRes: ==" + userLoginRes);

            if (userLoginRes != null) {
                return userLoginRes;
            }


            else {
                if (username != null) {
                    userLoginRes = memberDao.findByEmailStatusZero(username);
                    System.out.println("탈퇴한 회원입니다.");
                    return userLoginRes;
                }

                throw new UsernameNotFoundException("User not found with username: " + username);
            }

        } catch (Exception exception) {
            System.out.println("본인 인증 실패");
            return (UserDetails) exception;
        }
    }
}
