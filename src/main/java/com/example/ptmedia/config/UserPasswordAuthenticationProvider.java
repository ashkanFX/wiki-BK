package com.example.ptmedia.config;

import com.example.ptmedia.entity.Profile;
import com.example.ptmedia.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserPasswordAuthenticationProvider implements AuthenticationProvider {


    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();
        List<Profile> profiles = profileRepository.findByName(userName);
        if (profiles.size() > 0) {
            if (passwordEncoder.matches(password, profiles.get(0).getPassword())) {
                List<GrantedAuthority> authorities = new ArrayList<>();
                System.out.println(profiles.get(0).getRole());
                authorities.add(new SimpleGrantedAuthority(profiles.get(0).getRole()));
                return new UsernamePasswordAuthenticationToken(userName, password, authorities);
            } else {
                throw new BadCredentialsException("invalid pass");
            }
        } else {
            throw new BadCredentialsException("user is not register");

        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
