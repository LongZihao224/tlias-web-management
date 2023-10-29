package com.itheima;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;

@SpringBootTest
class TliasWebManagementApplicationTests {

    /**
     * 测试生成jwt
     */
    @Test
    public void testGenJwt(){
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "tom");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "itheima")  // 签名算法 itheima是salt
                .setClaims(claims)  // 自定义数据(载荷)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))  // 设置过期时间为1小时
                .compact();
        System.out.println(jwt);
    }

    /**
     * 测试解析jwt
     */
    @Test
    public void testParseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("itheima")  // 签名算法 itheima是salt
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY5ODAzNDQ0Mn0.wNB7wbVIUOSfnAMlGWWp-S8J9lJC_VX13kMDVawip-Q")
                .getBody();
        System.out.println(claims);
    }

}
