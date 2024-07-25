package com.example.ptmedia.config;

import com.example.ptmedia.entity.Profile;
import com.example.ptmedia.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetail implements UserDetailsService {

    @Autowired
    ProfileRepository profileRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        String name, password = null;
        List<GrantedAuthority> grantedAuthorities = null;
        List<Profile> profiles = profileRepository.findByName(userName);
        if (profiles.size() == 0) {
            throw new UsernameNotFoundException("user nadarim");
        } else {
            name = profiles.get(0).getName();
            password = profiles.get(0).getPassword();
            grantedAuthorities = new ArrayList<>();
            grantedAuthorities.add(new SimpleGrantedAuthority(profiles.get(0).getRole()));
        }

        return new User(name, password, grantedAuthorities);
    }


}
