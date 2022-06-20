package com.example.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImple implements UserDetailsService {

    @Autowired
    JdbcTemplate jdbcTemplate;
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
//          String sql = "SELECT * FROM user WHERE name ='" + username + "'";
            String sql = "SELECT * FROM [user] WHERE [mail] = ?";
                        
            Map<String, Object> map = jdbcTemplate.queryForMap(sql, username);
            
            String password = (String)map.get("password");

            Collection<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority((String)map.get("authority")));
            return new UserDetailsImple(username, password, authorities);
        } catch (Exception e) {
        	System.out.println(e.getMessage());
            throw new UsernameNotFoundException("user not found.", e);
        }
	}

}
