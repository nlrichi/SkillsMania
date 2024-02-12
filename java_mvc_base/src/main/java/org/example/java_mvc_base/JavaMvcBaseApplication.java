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
				avatar.setName("Avatar 1");
				avatar.setDescription("Description for Avatar 1");
				avatarRepository.save(avatar);
			}
		};
	}
}

