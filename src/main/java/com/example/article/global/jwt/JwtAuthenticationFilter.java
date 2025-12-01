package com.example.article.global.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final String AUTH_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";
    public static final String LOGIN_MEMBER_ATTR = "LOGIN_MEMBER";

    private final JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        String method = request.getMethod();
        if (isPublicPath(path) || isPreflight(method)) {
            filterChain.doFilter(request, response);
            return;
        }
        String authHeader = request.getHeader(AUTH_HEADER);
        if (!hasBearerToken(authHeader)) {
            writeUnauthorized(response, "Authorization 헤더가 없거나 형식이 올바르지 않습니다.");
            return;
        }
        String token = resolveToken(authHeader);
        if (!jwtProvider.validateToken(token)) {
            writeUnauthorized(response, "유효하지 않은 토큰입니다.");
            return;
        }
        String email = jwtProvider.getEmail(token);
        request.setAttribute(LOGIN_MEMBER_ATTR, email);
        filterChain.doFilter(request, response);
    }

    private boolean isPublicPath(String path) {
        return path.equals("/api/login")
                || path.equals("/api/signup")
                || path.startsWith("/css")
                || path.startsWith("/js")
                || path.endsWith(".html");
    }

    private boolean isPreflight(String method) {
        return "OPTIONS".equalsIgnoreCase(method);
    }

    private boolean hasBearerToken(String authHeader) {
        return authHeader != null && authHeader.startsWith(BEARER_PREFIX);
    }

    private String resolveToken(String authHeader) {
        return authHeader.substring(BEARER_PREFIX.length());
    }

    private void writeUnauthorized(HttpServletResponse response, String message) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter()
                .write("{\"message\":\"" + message + "\"}");
    }
}