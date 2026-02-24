package com.korit12.cardatabase.service;

import com.korit12.cardatabase.domain.AppUser;
import com.korit12.cardatabase.domain.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private AppUserRepository appUserRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> user = appUserRepository.findByUsername(username);
        UserBuilder builder = null;
        if (user.isPresent()) {
            AppUser currentUser = user.get();
            builder = User.withUsername(username)
                    .password(currentUser.getPassword())
                    .roles(currentUser.getRole());
        } else {
            throw new UsernameNotFoundException("해당 username을 가진 사용자를 찾지 못했습니다.");
        }
        return builder.build();
    }
}
