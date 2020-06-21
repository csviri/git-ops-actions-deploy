package com.coderealms.gitopsactions.deploy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DeployApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DeployApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(Arrays.toString(args));
    }
}