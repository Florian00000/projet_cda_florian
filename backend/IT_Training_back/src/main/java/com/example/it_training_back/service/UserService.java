package com.example.it_training_back.service;

import com.example.it_training_back.config.jwt.JwtTokenProvider;
import com.example.it_training_back.dto.user.UserDtoPost;
import com.example.it_training_back.entity.user.Role;
import com.example.it_training_back.entity.user.User;
import com.example.it_training_back.exception.NotFoundException;
import com.example.it_training_back.repository.user.RoleRepository;
import com.example.it_training_back.repository.user.UserRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public UserService(UserRepository userRepository, RoleRepository roleRepository,
                       @Lazy AuthenticationManager authenticationManager,
                       PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public boolean deleteRole(int id) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new NotFoundException("Role are not found"));
        roleRepository.delete(role);
        return true;
    }

    public Role findRole(String role) {
        return roleRepository.findByRole(role).orElseThrow(() -> new NotFoundException("Role are not found"));
    }

    public boolean createUser(UserDtoPost userDtoPost){
        try {
            User user = userDtoPost.convertToUser();
            user.setPassword(passwordEncoder.encode(userDtoPost.getPassword()));
            try {
                if (userDtoPost.getRoles() !=null && !userDtoPost.getRoles().isEmpty()){
                    List<Role> roles = userDtoPost.getRoles().stream()
                            .map(this::findRole).toList();
                    user.setRoles(roles);
                }else {
                    user.setRoles(List.of(findRole("ROLE_USER")));
                }
            }catch (Exception e){
                throw new IllegalArgumentException("problem with role allocation");
            }
            userRepository.save(user);
            return true;
        }catch (Exception e){
            throw new BadCredentialsException("invalid email or password");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
    }

    public boolean verifyUserPassword(String email, String password) {
        return userRepository.findByEmail(email).map(user -> passwordEncoder.matches(password, user.getPassword()))
                .orElseThrow(() -> new BadCredentialsException("invalid email or password"));
    }

    public boolean checkUserNameExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public String generateJwtToken(String email, String password, long userId) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication, userId);
        return token;
    }

    public long getIdByEmail(String email) {

        if (userRepository.findByEmail(email).isPresent()) {
            return userRepository.findByEmail(email).get().getId();
        }else throw new NotFoundException("User not found");
    }

}
