package org.itstep.i18n;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.security.RolesAllowed;

    @SpringBootApplication
    public class Application {
        @RolesAllowed("*")
        public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
        }
    }
