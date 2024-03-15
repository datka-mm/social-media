package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.config.jwt.JwtService;
import peaksoft.dto.request.SignUpRequest;
import peaksoft.dto.response.SignUpResponse;
import peaksoft.enums.Role;
import peaksoft.exceptions.AlreadyExistsException;
import peaksoft.model.User;
import peaksoft.repository.UserRepository;
import peaksoft.service.UserService;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public SignUpResponse signUp(SignUpRequest signUpRequest) {

//        userRepository.getUserByEmail(signUpRequest.email());

        if (userRepository.existsByEmail(signUpRequest.email())) {
            throw new AlreadyExistsException("User with " + signUpRequest.email() + " already exists");
        }

        User savedUser = userRepository.save(User.builder()
                .firstName(signUpRequest.firstName())
                .lastName(signUpRequest.lastName())
                .email(signUpRequest.email())
                .password(passwordEncoder.encode(signUpRequest.password()))
                .role(Role.CLIENT)
                .dateOfBirth(signUpRequest.dateOfBirth())
                .gender(signUpRequest.gender())
                .phoneNumber(signUpRequest.phoneNumber())
                .build());

        log.info("User successfully saved");

        return SignUpResponse.builder()
                .email(savedUser.getEmail())
                .role(savedUser.getRole())
                .token(jwtService.createToken(savedUser))
                .build();
    }
}
