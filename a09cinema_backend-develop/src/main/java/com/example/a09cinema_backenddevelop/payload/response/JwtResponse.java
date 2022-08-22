package com.example.a09cinema_backenddevelop.payload.response;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class  JwtResponse {
    private String token;
    private String type = "Bearer";
    private String name;

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    private Collection<?extends GrantedAuthority> roles;

    public JwtResponse() {
    }

    public JwtResponse(String token, String name, long id, Collection<? extends GrantedAuthority> roles) {
        this.token = token;
        this.name = name;
        this.roles = roles;
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }
}
