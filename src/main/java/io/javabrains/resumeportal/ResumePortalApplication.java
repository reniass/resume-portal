package io.javabrains.resumeportal;

import io.javabrains.resumeportal.models.User;
import io.javabrains.resumeportal.models.UserProfile;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ResumePortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumePortalApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(UserRepository userRepository, UserProfileRepository userProfileRepository) {
		return args -> {
			userRepository.save(new User("foo", "foo", true, "USER"));
			userRepository.save(new User("bar", "bar", true, "USER"));

			userProfileRepository.save(new UserProfile("foo", 1, "User name foo"));
			userProfileRepository.save(new UserProfile("bar", 2, "User name bar"));
		};
	}

}
