package com.macro.mall.tiny.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * jwtToken生成的工具类
 * @author Jay
 * @date 2021/4/27 3:23 下午
 */
@Component
public class JwtTokenUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);
    private static final String CLAIM_KEY_USERNAME="sub";
    private static final String CLAIM_KEY_CREATED="created";
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;

    /**
    * @Description: 生成token的过期时间
    * @Author: Jay
    * @Date: 2021/4/27 3:34 下午
    */
    private Date generateExpirationDate(){
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    /**
    * @Description: 根据负责生成JWT的token
    * @Author: Jay
    * @Date: 2021/4/27 3:36 下午
    */
    private String generateToken(Map<String,Object> claims){
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    /**
    * @Description: 从token中获取JWT中的负载
    * @Author: Jay
    * @Date: 2021/4/27 3:37 下午
    */
    private Claims getClaimsFromToken(String token){
      Claims claims = null;
      try{
          claims = Jwts.parser()
                  .setSigningKey(secret)
                  .parseClaimsJws(token)
                  .getBody();
      }catch (Exception e){
          LOGGER.info("JWT格式验证失败:{}",token);
      }
      return claims;
    }

    /**
    * @Description: 从token中获取登陆用户名
    * @Author: Jay
    * @Date: 2021/4/27 4:10 下午
    */
    public String getUserNameFromToken(String token){
        String username;
        try{
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        }catch (Exception e){
            username = null;
        }
        return username;
    }

    /**
    * @Description: 判断token是否失效
    * @Author: Jay
    * @Date: 2021/4/27 4:18 下午
    */
    private boolean isTokenExpired(String token){
        Date expiredDate = getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }

    /**
    * @Description: 从token中获取过期时间
    * @Author: Jay
    * @Date: 2021/4/27 4:19 下午
    */
    private Date getExpiredDateFromToken(String token){
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

    /**
    * @Description: 验证token是否还有效，就是判断该token的用户名和当前登陆的用户名一样不？并且判断该token是否过期
    * @Author: Jay
    * @Date: 2021/4/27 4:16 下午
    */
    public boolean validateToken(String token, UserDetails userDetails){
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername())&&!isTokenExpired(token);
    }

    /**
    * @Description: 根据用户信息生成token ，就是获取用户名和当前时间，组成map然后调用方法传入
    * @Author: Jay
    * @Date: 2021/4/27 4:22 下午
    */
    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME,userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(claims);
    }

    /**
    * @Description: 判断token是否可以被刷新 ，就是判断token有没有过期
    * @Author: Jay
    * @Date: 2021/4/27 4:25 下午
    */
    public boolean canRefresh(String token){
        return !isTokenExpired(token);
    }

    /**
    * @Description: 刷新token ,就是把时间更新为当前时间
    * @Author: Jay
    * @Date: 2021/4/27 4:25 下午
    */
    public String refreshToken(String token){
        Claims claims = getClaimsFromToken(token);
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }
}
