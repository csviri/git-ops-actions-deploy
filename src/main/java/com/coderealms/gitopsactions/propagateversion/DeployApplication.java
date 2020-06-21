package com.coderealms.gitopsactions.propagateversion;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeExceptionMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

import static com.coderealms.gitopsactions.propagateversion.ParamsUtils.toPropagationParams;

@SpringBootApplication
public class DeployApplication implements CommandLineRunner {

    private final PropagationService propagationService;

    public DeployApplication(PropagationService propagationService) {
        this.propagationService = propagationService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DeployApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println(Arrays.toString(args));
        PropagationParams propagationParams = toPropagationParams(args);
        propagationService.propagateVersion(propagationParams);
    }

    @Bean
    ExitCodeExceptionMapper exitCodeToExceptionMapper() {
        return exception -> 1;
    }
}
