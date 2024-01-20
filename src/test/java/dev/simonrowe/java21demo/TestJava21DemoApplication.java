package dev.simonrowe.java21demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestJava21DemoApplication {

	public static void main(String[] args) {
		SpringApplication.from(Java21DemoApplication::main).with(TestJava21DemoApplication.class).run(args);
	}

}
