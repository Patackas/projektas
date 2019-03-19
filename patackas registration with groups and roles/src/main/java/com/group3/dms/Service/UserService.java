package com.group3.dms.Service;

import com.group3.dms.Entity.Role;
import com.group3.dms.Entity.RoleGroup;
import com.group3.dms.Entity.User;
import com.group3.dms.Repository.RoleGroupRepository;
import com.group3.dms.Repository.RoleRepository;
import com.group3.dms.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service("userService")
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private RoleGroupRepository role2_Repository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       RoleGroupRepository role2_Repository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.role2_Repository = role2_Repository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("PEASANT");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        RoleGroup userRoleGroup = role2_Repository.findByRoleGroup("duxai");
        user.setRole_groups(new HashSet<RoleGroup>(Arrays.asList(userRoleGroup)));
        return userRepository.save(user);
    }

//    public Note findById(int id){
//        Note userNote = NoteRepository.findById("id");
//
//        return
//    }
}
