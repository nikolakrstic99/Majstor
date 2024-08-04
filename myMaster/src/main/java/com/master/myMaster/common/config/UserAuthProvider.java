package com.master.myMaster.common.config;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.master.myMaster.domains.User;
import com.auth0.jwt.JWT;
import com.master.myMaster.domains.UserStatus;
import jakarta.annotation.PostConstruct;
import java.util.Base64;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import java.util.Date;
@RequiredArgsConstructor
@Component
public class UserAuthProvider {

  @Value("${security.jwt.token.secret-key:secret-key}")
  private String secretKey;

  @PostConstruct
  protected void init() {
    secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
  }

  public String createToken(User user) {
    Date now = new Date();
    Date validity = new Date(now.getTime() + 3600000);

    return JWT.create()
        .withIssuer(user.getEmail())
        .withIssuedAt(now)
        .withExpiresAt(validity)
        .withClaim("firstName", user.getFirstName())
        .withClaim("lastName", user.getLastName())
        .withClaim("status", user.getStatus().name())
        .sign(Algorithm.HMAC256(secretKey));
  }

  public Authentication validateToken(String token) {
    Algorithm algorithm = Algorithm.HMAC256(secretKey);
    JWTVerifier verifier = JWT.require((algorithm)).build();
    DecodedJWT decodeJWT = verifier.verify(token);
    User user = User.builder()
        .email(decodeJWT.getIssuer())
        .firstName(decodeJWT.getClaim("firstName").asString())
        .lastName(decodeJWT.getClaim("lastName").asString())
        .status(UserStatus.valueOf(decodeJWT.getClaim("status").asString()))
        .build();
    return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
  }

  public User getUser() {
    return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  }

}
