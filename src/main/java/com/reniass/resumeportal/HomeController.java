package com.reniass.resumeportal;

import com.reniass.resumeportal.models.Education;
import com.reniass.resumeportal.models.Job;
import com.reniass.resumeportal.models.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }


    @GetMapping("/edit")
    public String edit(Principal principal, Model model, @RequestParam(required = false) String add) {
        String userName = principal.getName();
        Optional<UserProfile> userProfileOptional = userProfileRepository.findByUserName(userName);
        userProfileOptional.orElseThrow(() -> new RuntimeException("not found: " + userName));
        UserProfile userProfile = userProfileOptional.get();

        if("job".equals(add)) {
            userProfile.getJobs().add(new Job());
        } else if ("education".equals(add)) {
            userProfile.getEducations().add(new Education());
        } else if ("skill".equals(add)) {
            userProfile.getSkills().add("");
        }

        model.addAttribute("userName", userName);
        model.addAttribute("userProfile" , userProfile);

        System.out.println(userProfile.toString());

        return "profile-edit";
    }

    @PostMapping("/edit")
    public String postEdit(@ModelAttribute UserProfile userProfile, Principal principal) {
        System.out.println("From post edit controller \n " +
                userProfile.toString());


        String userName = principal.getName();
        Optional<UserProfile> userProfileOptional = userProfileRepository.findByUserName(userName);
        userProfileOptional.orElseThrow(() -> new RuntimeException("not found:" + userName));

        UserProfile savedUserProfile = userProfileOptional.get();

        userProfile.setId(savedUserProfile.getId());
        userProfile.setUserName(savedUserProfile.getUserName());

        userProfileRepository.save(userProfile);
        return "redirect:/view/" + userProfile.getUserName();
    }




    @GetMapping("/view/{userId}")
    public String view(@PathVariable String userId, Model model, Principal principal) {
        Optional<UserProfile> userProfileOptional = userProfileRepository.findByUserName(userId);
        userProfileOptional.orElseThrow(() -> new RuntimeException("not found: " + userId));

        UserProfile userProfile = userProfileOptional.get();
        userProfile.getJobs();
        model.addAttribute("userId", userId);
        model.addAttribute("userProfile", userProfile);

        boolean currentUserProfile = false;
        if (principal !=  null) {
            currentUserProfile = principal.getName().equals(userId);
        }
        model.addAttribute("currentUserProfile", currentUserProfile);

        return "profile-templates/"+ userProfile.getTheme() + "/index";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("type") String type, @RequestParam("index") int index, Principal principal) {
        String username = principal.getName();

        Optional<UserProfile> userProfileOptional= userProfileRepository.findByUserName(username);
        userProfileOptional.orElseThrow(() -> new RuntimeException("not found:" + username));

        UserProfile userProfile = userProfileOptional.get();

        if (type.equals("job")) {
            userProfile.getJobs().remove(index);
        } else if (type.equals("education")) {
            userProfile.getEducations().remove(index);
        } else if (type.equals("skill")) {
            userProfile.getSkills().remove(index);
        }



        return "redirect:/edit";
    }
}
