package za.ac.cput;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration

public class CounsellingApplication {
    public static void main(String[] args) {
        SpringApplication.run(CounsellingApplication.class, args);
    }
}
