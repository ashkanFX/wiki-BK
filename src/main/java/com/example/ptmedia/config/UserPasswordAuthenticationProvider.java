package com.example.ptmedia.config;

import com.example.ptmedia.entity.Authority;
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
import java.util.Set;

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
                return new UsernamePasswordAuthenticationToken(userName, password,
                        this.grantedAuthorities(profiles.get(0).getAuthorities()));
            } else {
                throw new BadCredentialsException("invalid pass");
            }
        } else {
            throw new BadCredentialsException("user is not register");

        }
    }

    private List<GrantedAuthority> grantedAuthorities(Set<Authority> authorities){
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority: authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        }
        return grantedAuthorities;
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
