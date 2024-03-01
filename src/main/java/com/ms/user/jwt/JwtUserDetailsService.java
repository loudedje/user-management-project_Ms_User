package com.ms.user.jwt;

import com.ms.user.model.UserModel;
import com.ms.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserModel userModel = userService.buscarPorEmail(email);
        return new JwtUserDetails(userModel);
    }

    public JwtToken getTokenAuthenticated(String email) {
        UserModel userModel = userService.buscarPorUserActive(email);
        return JwtUtils.createToken(email, userModel.isActive());
    }
}