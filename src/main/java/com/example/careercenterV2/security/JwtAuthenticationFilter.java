package com.example.careercenterV2.security;

import com.example.careercenterV2.repositories.CompanyRepository;
import com.example.careercenterV2.repositories.StudentRepository;
import com.example.careercenterV2.entities.Company;
import com.example.careercenterV2.entities.Student;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final StudentRepository studentRepository;
    private final CompanyRepository companyRepository;

    public JwtAuthenticationFilter(JwtService jwtService,
                                   StudentRepository studentRepository,
                                   CompanyRepository companyRepository) {
        this.jwtService = jwtService;
        this.studentRepository = studentRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        final String token = authHeader.substring(7);
        final String email = jwtService.extractEmail(token);
        final String role = jwtService.extractRole(token);

        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            AppUser user = null;
            if ("STUDENT".equals(role)) {
                user = studentRepository.findByEmail(email).orElse(null);
            } else if ("COMPANY".equals(role)) {
                user = companyRepository.findByEmail(email).orElse(null);
            }

            if (user != null && jwtService.isTokenValid(token, user)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        user, null, null);
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
