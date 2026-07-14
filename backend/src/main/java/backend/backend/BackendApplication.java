package backend.backend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {
	@Value("${server.port}")
	private static int port;
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		System.out.println("The backend is running on port :8081");
	}

}
