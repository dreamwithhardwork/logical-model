package org.models.core.auth;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;
import java.util.*;

public class JwtTokenUtil implements Serializable {
    private static final long serialVersionUID = -2550185165626007488L;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiry}")
    private Long expiry;


    public Claims getClaimsFromToken(String token) throws ExpiredJwtException, MalformedJwtException, SignatureException, IllegalArgumentException {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    public String getUserName(String token){
        return getClaimsFromToken(token).getSubject();
    }

    public List<String> getAuthoriries(String token){
        Claims claims = getClaimsFromToken(token);
        return (List<String>) claims.get("roles");
    }


    public boolean validate(String token){
        Claims claims= getClaimsFromToken(token);
        Date validity = claims.getExpiration();
        Date current = new Date();
        return current.before(validity);
    }
}
