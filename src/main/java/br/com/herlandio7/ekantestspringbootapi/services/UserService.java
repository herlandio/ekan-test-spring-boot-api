package br.com.herlandio7.ekantestspringbootapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.herlandio7.ekantestspringbootapi.models.User;
import br.com.herlandio7.ekantestspringbootapi.repositories.UserRepository;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                List.of(new SimpleGrantedAuthority(user.getRole())));
    }
}
