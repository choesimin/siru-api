package com.simin.siru.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.simin.siru.exception.TokenExpiredException;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtManager {
    private final String securityKey = "This_Is_A_Security_Key";
    private final Long expiredTime = 1000 * 60L * 60L;

    public String generateJwtToken(Long memberId) {
        Date date = new Date();
        return Jwts.builder()
            .setSubject("member")
            .setHeader(createHeader())
            .setClaims(createClaims(memberId))
            .setExpiration(new Date(date.getTime() + expiredTime))
            .signWith(SignatureAlgorithm.HS256, securityKey)
            .compact();
    }

    public Long getIdFromToken(String token) {
        return (Long) getClaims(token).get("id");
    }

    private Map<String, Object> createHeader() {
        Map<String, Object> header = new HashMap<>();
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        header.put("regdate", System.currentTimeMillis());
        return header;
    }

    private Map<String, Object> createClaims(Long memberId) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", memberId);
        return claims;
    }

    private Claims getClaims(String token) {
        checkToken(token);

        return Jwts.parser().setSigningKey(securityKey).parseClaimsJws(token).getBody();
    }

    private void checkToken(String token) {
        try {
            if (token.equals("null")) {
                throw new TokenExpiredException();
            }

            Jwts.parser().setSigningKey(securityKey).parseClaimsJws(token);
        } catch (ExpiredJwtException e) {
            throw new TokenExpiredException();
        }
    }
}
