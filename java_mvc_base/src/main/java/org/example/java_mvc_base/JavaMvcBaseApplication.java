package org.example.java_mvc_base;

import org.example.java_mvc_base.model.Avatar;
import org.example.java_mvc_base.repo.AvatarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaMvcBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaMvcBaseApplication.class, args);
	}

	@Autowired
	private AvatarRepository avatarRepository;

	@Bean
	CommandLineRunner initDatabase() {
		return args -> {
			// Check if an entry with this ID already exists to avoid duplicates
			if (!avatarRepository.existsById(1L)) {
				Avatar avatar = new Avatar();
				avatar.setId(1L);
				avatar.setImage("/images/Avatar1.png");
				avatar.setName("Avatar");
				avatar.setDescription("Basic Avatar");
				avatarRepository.save(avatar);
			}

			if (!avatarRepository.existsById(2L)) {
				Avatar avatar2 = new Avatar();
				avatar2.setId(2L);
				avatar2.setImage("/images/Avatar2.png");
				avatar2.setName("Man");
				avatar2.setDescription("Basic Male");
				avatarRepository.save(avatar2);
			}

			if (!avatarRepository.existsById(3L)) {
				Avatar avatar3 = new Avatar();
				avatar3.setId(3L);
				avatar3.setImage("/images/Avatar3.png");
				avatar3.setName("Woman");
				avatar3.setDescription("Basic Female");
				avatarRepository.save(avatar3);
			}
		};
	}
}

