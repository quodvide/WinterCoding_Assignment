package todolist;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class WinterCodingApplication {
    private static final String APPLICATION_LOCATIONS = "spring.config.location="
            + "classpath:application.properties,";

    public static void main(String[] args) {
        new SpringApplicationBuilder(WinterCodingApplication.class)
                .properties(APPLICATION_LOCATIONS)
                .run(args);
    }
}

