package et.ticketingsystem.ts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import et.ticketingsystem.ts.util.BatchRunner;

@SpringBootApplication
public class TsApplication {

	public static void main(String[] args) {
		
		BatchRunner btch = new BatchRunner();
		btch.run();
		SpringApplication.run(TsApplication.class, args);
	
	}

}
