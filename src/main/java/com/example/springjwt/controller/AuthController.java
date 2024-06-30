package com.example.springjwt.controller;

import com.example.springjwt.dto.JoinDTO;
import com.example.springjwt.entity.UserEntity;
import com.example.springjwt.repository.UserRepository;
import com.example.springjwt.service.JoinService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AuthController {

    private final JoinService joinService;
    private final UserRepository userRepository;

    public AuthController(JoinService joinService, UserRepository userRepository) {

        this.joinService = joinService;
        this.userRepository = userRepository;
    }

    @GetMapping("/join")
    public String join(Model model) {
        return "joinPage";
    }

    @PostMapping("/join")
    public String joinProcess(JoinDTO joinDTO) {

        boolean exist = userRepository.existsByUsername(joinDTO.getUsername());

        if (exist) {
            return "redirect:/join";
        }

        joinService.joinProcess(joinDTO);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "loginPage";
    }
}
