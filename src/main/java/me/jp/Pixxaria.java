package me.jp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "me.jp.repositories")
@EntityScan(basePackages = "me.jp.models")
public class Pixxaria {

	public static void main(String[] args) {
		SpringApplication.run(Pixxaria.class, args);
	}

}
