package data.config;

import data.member.model.UserLoginRes;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil implements Serializable {
    private static final long serialVersionUID = -2550185165626007488L;
    public static final long JWT_TOKEN_VALIDITY = 1 * 60 * 60;
    @Value("${jwt.secret}")
    private String secret;

    //jwt 토큰에서 사용자 이름 검색.
    public String getUsernameFromToken(String token) {
        System.out.println("토큰사용자 이름 검색");
        return getClaimFromToken(token, Claims::getSubject);
    }

    //jwt 토큰에서 만료 날짜 검색.
    public Date getExpirationDateFromToken(String token) {
        System.out.println("토큰만료 날짜");
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    // JWT에서 회원 정보 추출.
    private Claims getAllClaimsFromToken(String token) {
        System.out.println("회원벙보 추출");
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    //check if the token has expired
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    //Jwt 생성.
    public String generateToken(UserDetails userDetails) {
        System.out.println("일반토큰발급");
        UserLoginRes userLoginRes = (UserLoginRes) userDetails;
        Map<String, Object> claims = new HashMap<>();
        claims.put("social", "email");
        claims.put("email", userLoginRes.getUsername());
        claims.put("idx", userLoginRes.getIdx());
        claims.put("nickname", userLoginRes.getNickname());
        return doGenerateToken(claims, userLoginRes.getUsername());
    }

    //Jwt 생성.
    public String generateTokenForOAuth(String social, String email, String nickname) {
        System.out.println("소셜토큰생성");
        Map<String, Object> claims = new HashMap<>();
        claims.put("social", social);
        claims.put("email", email);
        claims.put("nickname", nickname);

        return doGenerateToken(claims, email);
    }

    //Jwt 발급.
    private String doGenerateToken(Map<String, Object> claims, String subject) {
        System.out.println("토큰발급");
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis() * 1000))
                .setExpiration(new Date((System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000) * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }
//    private String doGenerateToken(UserDetails userDetails) {
//        UserLoginRes userLoginRes = (UserLoginRes) userDetails;
//        Map<String, Object> idx = new HashMap<>();
//        Map<String, Object> nickname = new HashMap<>();
//        Map<String, Object> claims = new HashMap<>();
//        nickname.put("idx", userLoginRes.getIdx());
//        nickname.put("nickname", userLoginRes.getNickname());
//        nickname.put("username", userDetails.getUsername());
//        return Jwts.builder().setClaims(idx).setClaims(nickname).setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
//                .signWith(SignatureAlgorithm.HS512, secret).compact();
//    }

    // 토큰유효성 + 만료일자 확인.
    public Boolean validateToken(String token, UserDetails userDetails) {
        System.out.println("토큰유효+만료일자 확인");
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//        try {
//            final String username = getUsernameFromToken(token);
//            return (username.equals(userDetails.getUsername()));
//        } catch (SignatureException ex) {
//            System.out.println("Invalid JWT Signature");
//            return false;
//        } catch (ExpiredJwtException ex) {
//            System.out.println("Expired JWT token");
//            return false;
//        } catch (UnsupportedJwtException ex) {
//            System.out.println("Unsupported JWT exception");
//            return false;
//        } catch (IllegalArgumentException ex) {
//            System.out.println("Jwt claims string is empty");
//            return false;
//        }
    }
}











