package com.example.socialnetwork.socialnetwork.controller;

import com.example.socialnetwork.socialnetwork.domain.Message;
import com.example.socialnetwork.socialnetwork.domain.User;
import com.example.socialnetwork.socialnetwork.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {

    @Value("${spring.profiles.active}")
    private String profile;

    private final MessageRepo messageRepo;

    @Autowired
    public MainController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @GetMapping
    public String main(Model model, @AuthenticationPrincipal User user) {
        HashMap<Object, Object> data = new HashMap<>();
        data.put("profile", user);
        data.put("messages", messageRepo.findAll());
        model.addAttribute("frontendData", data);
        model.addAttribute("isDevMode", "dev".equals(profile ));
        return "index";
    }

    @MessageMapping("/changeMessage")
    @SendTo("/topic/activity")
    public Message change( Message message) {

        return messageRepo.save(message);
    }
}
