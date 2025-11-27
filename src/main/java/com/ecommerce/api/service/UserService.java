package com.ecommerce.api.service;

import com.ecommerce.api.dto.UserDTO;
import com.ecommerce.api.model.UserEntity;
import com.ecommerce.api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO createUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userDTO.email());
        userEntity.setPassword(userDTO.password());
        userEntity.setRole(userDTO.role());

        UserEntity savedUserEntity = userRepository.save(userEntity);

        return new UserDTO(
                savedUserEntity.getId(),
                savedUserEntity.getEmail(),
                savedUserEntity.getPassword(),
                savedUserEntity.getRole()
        );
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(userEntity -> new UserDTO(
                userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getRole()
            )
        ).toList();
    }

    public UserDTO getUserByEmail(String email) {
        Optional<UserEntity> userEntity = userRepository.findByEmail(email);
        return new UserDTO(
                userEntity.get().getId(),
                userEntity.get().getEmail(),
                userEntity.get().getPassword(),
                userEntity.get().getRole()
        );
    }
}
