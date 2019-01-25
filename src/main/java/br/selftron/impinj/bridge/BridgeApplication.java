package br.selftron.impinj.bridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("br.selftron.impinj.bridge")
@SpringBootApplication
public class BridgeApplication {

	public static void main(String[] args) {				
		SpringApplication.run(BridgeApplication.class, args);
	}
}
