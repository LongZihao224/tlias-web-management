package com.itheima.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {

    private static String signKey = "itheima";
    private static Long expire = 3600 * 1000L;

    /**
     * 生成Jwt令牌
     * @param claims JWT第二部分负载中存储的内容
     * @return
     */
    public static String createJwtToken(Map<String, Object> claims) {
        // 设置过期时间
        Date expiration = new Date(System.currentTimeMillis() + expire);
        // 生成Jwt令牌
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, signKey)  // 签名算法 itheima是salt
                .setClaims(claims)  // 自定义数据(载荷)
                .setExpiration(expiration)  // 设置过期时间
                .compact();
        return jwt;
    }

    /**
     * 解析Jwt令牌
     * @param jwt
     * @return
     */
    public static Map<String, Object> parseJwtToken(String jwt) {
        Map<String, Object> claims = Jwts.parser()
                .setSigningKey(signKey)  // 签名算法 itheima是salt
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }
}
