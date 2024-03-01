package com.ms.user.jwt;

import com.ms.user.model.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class JwtUserDetails  extends User {

    private UserModel userModel;
    public JwtUserDetails(UserModel userModel) {
        super(userModel.getEmail(),  userModel.getPassword(), AuthorityUtils.createAuthorityList(userModel.getEmail()));
        this.userModel =userModel;
    }
    public Long getId(){
        return this.getId();
    }
    public String getEmail(){
        return  this.getEmail();
    }
}