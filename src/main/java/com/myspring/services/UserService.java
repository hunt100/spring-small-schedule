package com.myspring.services;

import com.myspring.DB.UserBean;
import com.myspring.entities.Roles;
import com.myspring.entities.Users;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service

public class UserService implements UserDetailsService {

    private UserBean userBean;
    public UserBean getUserBean() {
        return userBean;
    }
    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public void save(Users user) {
        user.setPassword(DigestUtils.sha1Hex(user.getPassword()));
        Set<Roles>roles = new HashSet<>();
        roles.add(new Roles(2L,"ROLE_USER"));
        user.setRoles(roles);
        userBean.addUser(user);
    }



    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users myUser = userBean.getUser(s);
        Set<Roles> roles = myUser.getRoles();
        Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
        for(Roles r : roles){
            authorities.add(new SimpleGrantedAuthority(r.getRole()));
        }
        User securityUser = new User(myUser.getEmail(), myUser.getPassword(), authorities);
        return securityUser;
    }

}
