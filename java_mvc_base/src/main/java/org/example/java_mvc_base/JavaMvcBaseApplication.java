package org.example.java_mvc_base;


import org.example.java_mvc_base.model.*;
import org.example.java_mvc_base.repo.*;
import jakarta.annotation.PostConstruct;
import org.example.java_mvc_base.model.Avatar;
import org.example.java_mvc_base.model.Goal;
import org.example.java_mvc_base.model.LeagueUpdateThread;
import org.example.java_mvc_base.repo.AvatarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import java.util.List;


@SpringBootApplication
public class JavaMvcBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaMvcBaseApplication.class, args);

		leagueUpdateThread = BeanUtil.getBean(LeagueUpdateThread.class);
		leagueUpdateThread.setRunning(true);
		leagueUpdateThread.run();
	}

	@Autowired
	private AvatarRepository avatarRepository;

	@Autowired
	private CourseRepository c_repo;

	@Autowired
	private BadgeRepository badgeRepository;

	@Autowired
	private GoalRepository goalRepository;


	@Autowired
	LeagueTableRepository league_repo;

	@Autowired
	UserRepository u_repo;

	static LeagueUpdateThread leagueUpdateThread;

	@Bean
	CommandLineRunner initDatabase() {
		return args -> {
			List<Avatar> avatars = new ArrayList<>();
			// Check if an entry with this ID already exists to avoid duplicates
			if (!avatarRepository.existsById(1L)) {
				Avatar avatar = new Avatar();
				avatar.setId(1L);
				avatar.setImage("/images/Avatar1.png");
				avatar.setName("Avatar");
				avatar.setDescription("Basic Avatar");
				avatarRepository.save(avatar);
				avatars.add(avatar);
			}

			if (!avatarRepository.existsById(2L)) {
				Avatar avatar2 = new Avatar();
				avatar2.setId(2L);
				avatar2.setImage("/images/Avatar2.png");
				avatar2.setName("Man");
				avatar2.setDescription("Basic Male");
				avatarRepository.save(avatar2);
				avatars.add(avatar2);
			}

			if (!avatarRepository.existsById(3L)) {
				Avatar avatar3 = new Avatar();
				avatar3.setId(3L);
				avatar3.setImage("/images/Avatar3.png");
				avatar3.setName("Woman");
				avatar3.setDescription("Basic Female");
				avatarRepository.save(avatar3);
				avatars.add(avatar3);
			}

			Badge badge = new Badge();
			badge.setId(1);
			badge.setIconPath("/images/badge.jpeg");
			badge.setName("Badge1");
			badge.setDescription("Badge 1");
			badge = badgeRepository.save(badge);

			List<String> names = new ArrayList<>(Arrays.asList("Jamie", "Ezekiel", "Mohammed",
					"Dele", "Ayo", "John", "T_boy", "Helen", "Aisha", "Sophia", "Tom", "Jibril",
					"Jeyda", "Erling", "Timothy", "Joyce", "Ethan", "Yusuf", "Lyla", "Gloria",
					"Teddy", "Joshua", "Ashanti", "Claire", "Patrick", "Abdul", "Saira", "Kenny",
					"Alex", "Diddy", "Learner1", "am_i_real", "guy_jj", "t__", "its_rosa", "Naby_lad")); //36

			LeagueTable league1 = new LeagueTable();
			league1.setTierName("Kings Intelligence");
			league1 = league_repo.save(league1);

			LeagueTable league2 = new LeagueTable();
			league2.setTierName("Artificial Champions");
			league2 = league_repo.save(league2);

			LeagueTable league3 = new LeagueTable();
			league3.setTierName("Bronze");
			league3 = league_repo.save(league3);

			int min = 1;  // Minimum value (inclusive)
			int max = 100;  // Maximum value (exclusive)

			// Create a Random object



			for (int i=0; i < 12; i++){
				User dummy = new User();
				dummy.setUsername(names.get(i));
				Random random = new Random();

				// Generate a random integer between min and max
				int randomNumber = random.nextInt(max - min) + min;

				dummy.setLeagueXP(randomNumber);
				dummy.setLeagueId(league1.getLeagueId());
				dummy = u_repo.save(dummy);


				league1.getMembers().add(dummy);
				league1 = league_repo.save(league1);
			}

			for (int i=12; i < 24; i++){
				User dummy = new User();
				dummy.setUsername(names.get(i));
				Random random = new Random();

				// Generate a random integer between min and max
				int randomNumber = random.nextInt(max - min) + min;
				dummy.setLeagueXP(randomNumber);
				dummy.setLeagueId(league2.getLeagueId());
				dummy = u_repo.save(dummy);

				league2.getMembers().add(dummy);
				league2 = league_repo.save(league2);
			}

			for (int i=24; i < 36; i++){
				User dummy = new User();
				dummy.setUsername(names.get(i));
				Random random = new Random();

				// Generate a random integer between min and max
				int randomNumber = random.nextInt(max - min) + min;
				dummy.setLeagueXP(randomNumber);
				dummy.setLeagueId(league3.getLeagueId());
				dummy = u_repo.save(dummy);

				league3.getMembers().add(dummy);
				league3 = league_repo.save(league3);
			}





		};

	}

	@PostConstruct
	public void initGoals() {
		// Check if goals already exist to avoid duplication
		if (goalRepository.count() == 0) {
			// Define and save the goals if they don't exist
			goalRepository.saveAll(List.of(
					new Goal("Complete one course in a day", "daily", 1, 100),
					new Goal("Complete two courses in a week", "weekly", 2, 300),
					new Goal("Complete three courses in a month", "monthly", 3, 500)
			));
		}
	}
}

