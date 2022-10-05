package myboot.app4.test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class JWTTest {
    @Test
    void test() {
        // Maintenant et cinq secondes plus tard
        Date now = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(now);
        c.add(Calendar.SECOND, 5);
        Date nowPlus5Seconds = c.getTime();

        // un secret pour signer le token
        String secretText = "Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E=";
        byte[] secret = TextCodec.BASE64.decode(secretText);

        // construction d'un JWT
        String jws = Jwts.builder()//
                .setIssuer("Jean-Luc MASSAT")//
                .setSubject("Test JWT")//
                .claim("name", "JLM")//
                .claim("scope", "admin")//
                .setIssuedAt(now)//
                .setExpiration(nowPlus5Seconds)//
                .signWith(SignatureAlgorithm.HS256, secret).compact();
        System.out.println(jws);

        // Décodage d'un JWT
        Jws<Claims> jwsDecoded = Jwts.parser()//
                .setSigningKey(secret)//
                .parseClaimsJws(jws);
        System.out.println(jwsDecoded);


    }
}
