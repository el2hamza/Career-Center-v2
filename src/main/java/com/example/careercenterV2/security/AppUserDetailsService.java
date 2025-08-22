package com.example.careercenterV2.security;

import com.example.careercenterV2.entities.Company;
import com.example.careercenterV2.entities.Student;
import com.example.careercenterV2.repositories.CompanyRepository;
import com.example.careercenterV2.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {
    private final StudentRepository studentRepository;
    private final CompanyRepository companyRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Student s = studentRepository.findByEmail(email).orElse(null);
        if (s != null) {
            return new User(s.getEmail(), s.getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority("STUDENT")));
        }
        Company c = companyRepository.findByEmail(email).orElse(null);
        if (c != null) {
            return new User(c.getEmail(), c.getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority("COMPANY")));
        }
        throw new UsernameNotFoundException("User not found with email: " + email);
    }
}
