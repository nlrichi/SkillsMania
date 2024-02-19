package org.example.java_mvc_base;

import org.example.java_mvc_base.model.LeagueUpdateThread;
import org.example.java_mvc_base.repo.LeagueTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JavaMvcBaseApplication {
	@Autowired
	LeagueTableRepository league_repo;


	static LeagueUpdateThread leagueUpdateThread;

	public static void main(String[] args) {

		SpringApplication.run(JavaMvcBaseApplication.class, args);

		//get the Beaned thread subclass, giving it access to repos
		leagueUpdateThread = BeanUtil.getBean(LeagueUpdateThread.class);

		//Start the tread as well with the application
		leagueUpdateThread.setRunning(true);
		leagueUpdateThread.run();

	}

}
