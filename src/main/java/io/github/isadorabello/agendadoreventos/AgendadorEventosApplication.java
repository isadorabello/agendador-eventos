package io.github.isadorabello.agendadoreventos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AgendadorEventosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendadorEventosApplication.class, args);
	}

}
