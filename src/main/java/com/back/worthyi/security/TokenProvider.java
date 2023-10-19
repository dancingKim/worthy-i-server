package com.back.worthyi.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Slf4j
@Service
public class TokenProvider {
    private static final String SECRET_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9cAOIAifu3fykvhkHpbuhbvtH807Z2rI1FS3vX1XMjE";

    public String create(final Authentication authentication){
        ApplicationOAuth2User userPrincipal = (ApplicationOAuth2User) authentication.getPrincipal();

        Date expiryData = Date.from(
                Instant.now()
                        .plus(1, ChronoUnit.DAYS));
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .setSubject(userPrincipal.getName()) // sub
                .setIssuer("user")
                .setIssuedAt(new Date())
                .setExpiration(expiryData)
                .compact();
    }

    public String validateAndGetUserId(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();

        return  claims.getSubject();
    }
}
