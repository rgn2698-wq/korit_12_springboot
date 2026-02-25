package com.korit12.cardatabase.web;

import com.korit12.cardatabase.domain.AccountCredentials;
import com.korit12.cardatabase.service.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class LoginController {
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;

    // 로그인이니까 POST 요청
    @PostMapping("/login")
    public ResponseEntity<?> getToken(@RequestBody AccountCredentials credentials) {
        // 토큰 생성하고 응답의 authorization 헤더로 전송해주는 로직.
        UsernamePasswordAuthenticationToken creds = new UsernamePasswordAuthenticationToken(credentials.username(), credentials.password());
        Authentication auth = authenticationManager.authenticate(creds);

        // 토큰 생성하는 jwtService의 getToken() 메서드를 호출하여 그 결과값을 대입 -> 지역변수
        String jwts = jwtService.getToken(auth.getName());  // Java 내에서만 만들어진거라 외부에서 볼수 없다.

        // 29번 라인의 결과jwt가 String 자료형으로 저장되었고, 이를 headers의 authorization 부분에 저장됨
        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION,"Bearer "+ jwts)
                .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Authorization")
                .build();
    }

}
