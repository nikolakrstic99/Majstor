package com.master.myMaster.common.config;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.master.myMaster.domains.UserDto;
import com.auth0.jwt.JWT;
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

  public String createToken(UserDto userDto) {
    Date now = new Date();
    Date validity = new Date(now.getTime() + 3600000);

    return JWT.create()
        .withIssuer(userDto.getEmail())
        .withIssuedAt(now)
        .withExpiresAt(validity)
        .withClaim("firstName", userDto.getFirstName())
        .withClaim("lastName", userDto.getLastName())
        .sign(Algorithm.HMAC256(secretKey));
  }

  public Authentication validateToken(String token) {
    Algorithm algorithm = Algorithm.HMAC256(secretKey);
    JWTVerifier verifier = JWT.require((algorithm)).build();
    DecodedJWT decodeJWT = verifier.verify(token);
    UserDto userDto = UserDto.builder()
        .email(decodeJWT.getIssuer())
        .firstName(decodeJWT.getClaim("firstName").asString())
        .lastName(decodeJWT.getClaim("lastName").asString())
        .build();
    return new UsernamePasswordAuthenticationToken(userDto, null, Collections.emptyList());
  }

  public UserDto getUser() {
    return (UserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  }

}
