package com.example.identityservice.config;

import com.example.identityservice.entity.User;
import com.example.identityservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            User student = new User();
            student.setUsername("student1");
            student.setPassword(passwordEncoder.encode("123456"));
            student.setRole("STUDENT");
            userRepository.save(student);

            User instructor = new User();
            instructor.setUsername("instructor1");
            instructor.setPassword(passwordEncoder.encode("123456"));
            instructor.setRole("INSTRUCTOR");
            userRepository.save(instructor);

            System.out.println(">>> Da tao xong dữ liệu mẫu (student1 / instructor1)!");
        }
    }
}