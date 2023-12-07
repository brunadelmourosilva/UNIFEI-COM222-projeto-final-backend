package br.com.unifei.projetoclinica.services;

import br.com.unifei.projetoclinica.dto.request.UpdateUserRequest;
import br.com.unifei.projetoclinica.dto.request.UserRequest;
import br.com.unifei.projetoclinica.dto.response.UpdateUserResponse;
import br.com.unifei.projetoclinica.dto.response.UserResponse;
import br.com.unifei.projetoclinica.exceptions.BadRequestException;
import br.com.unifei.projetoclinica.exceptions.NotFoundException;
import br.com.unifei.projetoclinica.mappers.UserMapper;
import br.com.unifei.projetoclinica.models.User;
import br.com.unifei.projetoclinica.repositories.ClinicRepository;
import br.com.unifei.projetoclinica.repositories.RoleRepository;
import br.com.unifei.projetoclinica.repositories.UserRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    public void createUser(UserRequest userRequest, String clinicId) {
        if(userRepository.findByEmail(userRequest.email()).isPresent()){
            throw new BadRequestException("User already exists.");
        }

        var clinic = clinicRepository.findById(clinicId).orElseThrow(() ->
                new NotFoundException("Clinic not found."));

        var user = User.builder()
                .name(userRequest.name())
                .email(userRequest.email())
                .password(passwordEncoder.encode(userRequest.password()))
                .clinic(clinic)
                .build();

        var adminRole = roleRepository.findByRoleName("ROLE_ADMIN").orElseThrow(
                () -> new NotFoundException("Role not found.")
        );
        user.setRoles(List.of(adminRole));

        userRepository.save(user);
    }

    public UpdateUserResponse updateUser(UpdateUserRequest updateUserRequest, String userId) {
        var user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found."));

        user.setName(updateUserRequest.name());
        user.setEmail(updateUserRequest.email());
        user.setPassword(passwordEncoder.encode(updateUserRequest.password()));

        userRepository.save(user);

        return userMapper.mapUserEntityToUserResponse(user);
    }

    public List<UserResponse> getAllUsers() {
        var user = userRepository.findAll();

        return userMapper.mapUserEntityToUserResponse(user);
    }

  public UserResponse getUserById(String userId) {
    var user =
        userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found."));

    return userMapper.mapUserEntityToUserResponseUnique(user);
  }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
