package data.member.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.math.BigInteger;
import java.util.Collection;

@Getter
@Setter

public class UserLoginRes extends User {
    BigInteger idx;
    String email;
    String nickname;
    String profile_image;
    public UserLoginRes(BigInteger idx, String username, String password, String nickname,String profile_image, Collection<?
            extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.idx = idx;
        this.email = username;
        this.nickname = nickname;
        this.profile_image = profile_image;
    }
}
