package javaee.demo.angular2.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Yehoshua on 23/02/16.
 */

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@ComponentScan(basePackages = "javaee.demo.angular2.service")
public class ApplicationTest {

}
