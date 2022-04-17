package io.javabrains.resumeportal;

import io.javabrains.resumeportal.models.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "hello";
    }

    @GetMapping("/edit")
    @ResponseBody
    public String edit() {
        return "edit page";
    }

    @GetMapping("/view/{userId}")
    public String view(@PathVariable String userId, Model model) {
        Optional<UserProfile> userProfileOptional = userProfileRepository.findByUserName(userId);
        userProfileOptional.orElseThrow(() -> new RuntimeException("not found: " + userId));

        UserProfile userProfile = userProfileOptional.get();
        model.addAttribute("userId", userId);
        model.addAttribute("userProfile", userProfile);
        return "profile-templates/2/index";
    }
}
