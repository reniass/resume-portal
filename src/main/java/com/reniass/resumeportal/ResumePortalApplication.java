package com.reniass.resumeportal;

import com.reniass.resumeportal.models.Education;
import com.reniass.resumeportal.models.Job;
import com.reniass.resumeportal.models.User;
import com.reniass.resumeportal.models.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
public class ResumePortalApplication {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserProfileRepository userProfileRepository;

	public static void main(String[] args) {
		SpringApplication.run(ResumePortalApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(UserRepository userRepository, UserProfileRepository userProfileRepository) {
		return args -> {
			userRepository.save(new User("einstein", "einstein", true, "USER"));
			userRepository.save(new User("newton", "newton", true, "USER"));

			List<Job> jobs1 = new ArrayList<>();
			List<String> responsibilitiesJob1 = new ArrayList<>();
			responsibilitiesJob1.add("Come up with theory of relativity");
			responsibilitiesJob1.add("Advance quantum mechanics");
			responsibilitiesJob1.add("Blow people's minds");
			List<String> responsibilitiesJob2 = new ArrayList<>();
			responsibilitiesJob2.add("Come up with theory of relativity");
			responsibilitiesJob2.add("Advance quantum mechanics");
			responsibilitiesJob2.add("Blow people's minds");
			Job job1 = new Job("Company 1", "Designation 1", LocalDate.of(2019, 5, 1), true, responsibilitiesJob1);
			Job job2 = new Job("Company 2", "Designation 2", LocalDate.of(2020, 5, 1), LocalDate.of(2020, 3, 1), false, responsibilitiesJob2);
			jobs1.add(job1);
			jobs1.add(job2);
			List<String> skills1 = new ArrayList<>();
			skills1.add("problem-solving");
			skills1.add("Data analysis and the communication of complex ideas");
			skills1.add("Wider understanding of how the world works on a scientific and human level");

			List<Education> educations1 = new ArrayList<>();
			educations1.add(new Education("Awesome college", "Useless degree",
					LocalDate.of(2003, 9, 1), LocalDate.of(2008, 6, 30), "Studied a lot"));
			educations1.add(new Education("Awesome college", "Useless degree",
					LocalDate.of(2003, 9, 1), LocalDate.of(2008, 6, 30), "Studied a lot"));

			userProfileRepository.save(new UserProfile("einstein", "Albert", "Einstein", "111-1111-11", "einstein@gmail.com",  1,
					"Widely acknowledged to be one of the greatest and most influential physicists of all time. Einstein is best known for developing the theory of relativity.", "theoretical physicist",
					jobs1, skills1, educations1));

			List<Job> jobs2 = new ArrayList<>();
			List<String> responsibilitiesJob3 = new ArrayList<>();
			responsibilitiesJob3.add("Expand mathematical knowledge by developing new principles");
			responsibilitiesJob3.add("Recognize previously unknown relationships between mathematical principles");
			responsibilitiesJob3.add("Create models to resolve practical problems in fields such as business, engineering and science");
			List<String> responsibilitiesJob4 = new ArrayList<>();
			responsibilitiesJob4.add("Expand mathematical knowledge by developing new principles");
			responsibilitiesJob4.add("Recognize previously unknown relationships between mathematical principles");
			responsibilitiesJob4.add("Create models to resolve practical problems in fields such as business, engineering and science");
			Job job3 = new Job("Company 3", "Designation 3", LocalDate.of(2019, 5, 1), true, responsibilitiesJob3);
			Job job4 = new Job("Company 4", "Designation 4", LocalDate.of(2020, 5, 1), LocalDate.of(2020, 3, 1), false, responsibilitiesJob4);
			jobs2.add(job3);
			jobs2.add(job4);

			List<String> skills2 = new ArrayList<>();
			skills2.add("Develop theoretical proofs of math models for casino games");
			skills2.add("Determine mathematical feasibility of game designs");
			skills2.add("Create and troubleshoot computer simulations of casino games to gather statistics and verify mathematical validity");

			List<Education> educations2 = new ArrayList<>();
			educations2.add(new Education("Awesome college", "Useless degree",
					LocalDate.of(2003, 9, 1), LocalDate.of(2008, 6, 30), "Studied a lot"));
			educations2.add(new Education("Awesome college", "Useless degree",
					LocalDate.of(2003, 9, 1), LocalDate.of(2008, 6, 30), "Studied a lot"));


			userProfileRepository.save(new UserProfile("newton", "Isaac", "Newton", "222-2222-22", "newton@gmail.com", 1,
					"Widely recognised as one of the greatest mathematicians and physicists of all time and among the most influential scientists. He was a key figure in the philosophical revolution known as the Enlightenment.", " mathematician, physicist, astronomer, alchemist, theologian, and author",
					jobs2, skills2, educations2));
		};
	}

}
