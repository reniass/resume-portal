package io.javabrains.resumeportal;

import io.javabrains.resumeportal.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class ResumePortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumePortalApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(UserRepository userRepository) {
		return args -> {
			userRepository.save(new User("foo", "foo", true, "USER"));
			userRepository.save(new User("bar", "bar", true, "USER"));
		};
	}

}
