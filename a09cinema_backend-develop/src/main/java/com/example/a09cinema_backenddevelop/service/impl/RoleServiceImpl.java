package com.example.a09cinema_backenddevelop.service.impl;

import com.example.a09cinema_backenddevelop.service.RoleService;
import com.example.a09cinema_backenddevelop.model.entity.Role;
import com.example.a09cinema_backenddevelop.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
