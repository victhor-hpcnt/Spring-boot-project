package com.sample.test;


import com.sample.test.config.CustomUserDetails;
import com.sample.test.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EntityScan(basePackageClasses = {Jsr310Converters.class }, basePackages = {"com.sample.test.entity"})
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, UserDao dao) throws Exception {
        builder.userDetailsService(
                username -> new CustomUserDetails(dao.findByUsername(username)
                        .get())).passwordEncoder(new BCryptPasswordEncoder());
    }


}
